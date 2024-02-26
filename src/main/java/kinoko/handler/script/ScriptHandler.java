package kinoko.handler.script;

import kinoko.handler.Handler;
import kinoko.packet.script.ScriptMessageType;
import kinoko.packet.user.UserLocal;
import kinoko.packet.user.UserRemote;
import kinoko.packet.user.effect.Effect;
import kinoko.packet.world.WvsContext;
import kinoko.packet.world.message.Message;
import kinoko.provider.QuestProvider;
import kinoko.provider.map.PortalInfo;
import kinoko.provider.quest.QuestInfo;
import kinoko.server.header.InHeader;
import kinoko.server.packet.InPacket;
import kinoko.server.script.NpcScriptManager;
import kinoko.server.script.ScriptAnswer;
import kinoko.server.script.ScriptDispatcher;
import kinoko.util.Tuple;
import kinoko.world.field.life.npc.Npc;
import kinoko.world.quest.QuestRecord;
import kinoko.world.quest.QuestRequestType;
import kinoko.world.quest.QuestResult;
import kinoko.world.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public final class ScriptHandler {
    private static final Logger log = LogManager.getLogger(ScriptHandler.class);

    @Handler(InHeader.USER_SELECT_NPC)
    public static void handleUserSelectNpc(User user, InPacket inPacket) {
        final int objectId = inPacket.decodeInt(); // dwNpcId
        final short x = inPacket.decodeShort(); // ptUserPos.x
        final short y = inPacket.decodeShort(); // ptUserPos.y
        final Optional<Npc> npcResult = user.getField().getNpcPool().getById(objectId);
        if (npcResult.isEmpty()) {
            log.error("Tried to select invalid npc ID : {}", objectId);
            return;
        }
        final Npc npc = npcResult.get();
        if (npc.getScript().isEmpty()) {
            log.error("Npc template ID {} does not have an associated script", npc.getTemplateId());
            return;
        }
        ScriptDispatcher.startNpcScript(user, npc.getTemplateId(), npc.getScript().get());
    }

    @Handler(InHeader.USER_SCRIPT_MESSAGE_ANSWER)
    public static void handleUserScriptMessageAnswer(User user, InPacket inPacket) {
        final byte type = inPacket.decodeByte(); // nMsgType
        final byte action = inPacket.decodeByte();

        final ScriptMessageType lastMessageType = ScriptMessageType.getByValue(type);

        final Optional<NpcScriptManager> scriptManagerResult = ScriptDispatcher.getNpcScriptManager(user);
        if (scriptManagerResult.isEmpty()) {
            log.error("Could not retrieve ScriptManager instance for character ID : {}", user.getCharacterId());
            return;
        }
        final NpcScriptManager scriptManager = scriptManagerResult.get();
        switch (lastMessageType) {
            case SAY, SAY_IMAGE, ASK_YES_NO, ASK_ACCEPT -> {
                scriptManager.submitAnswer(ScriptAnswer.withAction(action));
            }
            case ASK_TEXT, ASK_BOX_TEXT -> {
                if (action == 1) {
                    final String answer = inPacket.decodeString(); // sInputStr_Result
                    scriptManager.submitAnswer(ScriptAnswer.withTextAnswer(action, answer));
                } else {
                    scriptManager.submitAnswer(ScriptAnswer.withAction(-1));
                }
            }
            case ASK_NUMBER, ASK_MENU, ASK_SLIDE_MENU -> {
                if (action == 1) {
                    final int answer = inPacket.decodeInt(); // nInputNo_Result | nSelect
                    scriptManager.submitAnswer(ScriptAnswer.withAnswer(action, answer));
                } else {
                    scriptManager.submitAnswer(ScriptAnswer.withAction(-1));
                }
            }
            case ASK_AVATAR, ASK_MEMBER_SHOP_AVATAR -> {
                if (action == 1) {
                    final byte answer = inPacket.decodeByte(); // nAvatarIndex
                    scriptManager.submitAnswer(ScriptAnswer.withAnswer(action, answer));
                } else {
                    scriptManager.submitAnswer(ScriptAnswer.withAction(-1));
                }
            }
            case null -> {
                log.error("Unknown script message type {}", type);
            }
            default -> {
                log.error("Unhandled script message type {}", lastMessageType);
            }
        }
    }

    @Handler(InHeader.USER_PORTAL_SCRIPT_REQUEST)
    public static void handleUserPortalScriptRequest(User user, InPacket inPacket) {
        final byte fieldKey = inPacket.decodeByte(); // bFieldKey
        if (user.getField().getFieldKey() != fieldKey) {
            user.dispose();
            return;
        }
        final String portalName = inPacket.decodeString(); // sName
        final short x = inPacket.decodeShort(); // GetPos()->x
        final short y = inPacket.decodeShort(); // GetPos()->y
        final Optional<PortalInfo> portalResult = user.getField().getPortalByName(portalName);
        if (portalResult.isEmpty() || portalResult.get().getScript() == null) {
            user.dispose();
            return;
        }
        ScriptDispatcher.startPortalScript(user, portalResult.get());
    }

    @Handler(InHeader.USER_QUEST_REQUEST)
    public static void handleUserQuestRequest(User user, InPacket inPacket) {
        final byte action = inPacket.decodeByte();
        final int questId = Short.toUnsignedInt(inPacket.decodeShort()); // usQuestID

        final Optional<QuestInfo> questInfoResult = QuestProvider.getQuestInfo(questId);
        if (questInfoResult.isEmpty()) {
            log.error("Could not retrieve quest ID : {}", questId);
            return;
        }
        final QuestInfo questInfo = questInfoResult.get();

        final QuestRequestType questRequestType = QuestRequestType.getByValue(action);
        switch (questRequestType) {
            case LOST_ITEM -> {
                final int size = inPacket.decodeInt();
                final int[] lostItems = new int[size];
                for (int i = 0; i < size; i++) {
                    lostItems[i] = inPacket.decodeInt();
                }
                // TODO
            }
            case ACCEPT_QUEST -> {
                final int templateId = inPacket.decodeInt(); // dwNpcTemplateID
                final int itemPos = inPacket.decodeInt(); // CWvsContext.m_nQuestDeliveryItemPos
                if (!questInfo.isAutoAlert()) {
                    final short x = inPacket.decodeShort(); // ptUserPos.x
                    final short y = inPacket.decodeShort(); // ptUserPos.y
                }
                try (var locked = user.acquire()) {
                    final Optional<QuestRecord> startQuestResult = questInfo.startQuest(user);
                    if (startQuestResult.isEmpty()) {
                        log.error("Failed to accept quest : {}", questId);
                        user.dispose();
                        return;
                    }
                    user.write(WvsContext.message(Message.questRecord(startQuestResult.get())));
                    user.write(UserLocal.questResult(QuestResult.success(questId, templateId, 0)));
                }
            }
            case COMPLETE_QUEST -> {
                final int templateId = inPacket.decodeInt(); // dwNpcTemplateID
                final int itemPos = inPacket.decodeInt(); // CWvsContext.m_nQuestDeliveryItemPos
                if (!questInfo.isAutoAlert()) {
                    final short x = inPacket.decodeShort(); // ptUserPos.x
                    final short y = inPacket.decodeShort(); // ptUserPos.y
                }
                final int index = inPacket.decodeInt(); // nIdx, for selecting reward? TODO
                try (var locked = user.acquire()) {
                    final Optional<Tuple<QuestRecord, Integer>> questCompleteResult = questInfo.completeQuest(user);
                    if (questCompleteResult.isEmpty()) {
                        log.error("Failed to complete quest : {}", questId);
                        user.dispose();
                        return;
                    }
                    final QuestRecord qr = questCompleteResult.get().getLeft();
                    final int nextQuest = questCompleteResult.get().getRight();
                    user.write(WvsContext.message(Message.questRecord(questCompleteResult.get().getLeft())));
                    user.write(UserLocal.questResult(QuestResult.success(questId, templateId, nextQuest)));
                }
                // Quest complete effect
                user.write(UserLocal.effect(Effect.questComplete()));
                user.getField().broadcastPacket(UserRemote.effect(user, Effect.questComplete()), user);
            }
            case RESIGN_QUEST -> {
                try (var locked = user.acquire()) {
                    final Optional<QuestRecord> questRecordResult = questInfo.resignQuest(user);
                    if (questRecordResult.isEmpty()) {
                        log.error("Failed to resign quest : {}", questId);
                        return;
                    }
                    user.write(WvsContext.message(Message.questRecord(questRecordResult.get())));
                    user.write(UserLocal.resignQuestReturn(questId));
                }
            }
            case OPENING_SCRIPT, COMPLETE_SCRIPT -> {
                final int templateId = inPacket.decodeInt(); // dwNpcTemplateID
                final short x = inPacket.decodeShort(); // ptUserPos.x
                final short y = inPacket.decodeShort(); // ptUserPos.y
                ScriptDispatcher.startQuestScript(user, templateId, questId, questRequestType == QuestRequestType.OPENING_SCRIPT);
            }
            case null -> {
                log.error("Unknown quest action type : {}", action);
            }
            default -> {
                log.error("Unhandled quest action type : {}", questRequestType);
            }
        }
    }
}
