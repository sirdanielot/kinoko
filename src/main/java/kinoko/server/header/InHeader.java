package kinoko.server.header;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Enum SendOps.
 */
public enum InHeader {
    // BEGIN_SOCKET(0),
    CHECK_PASSWORD(1),
    GUEST_ID_LOGIN(2),
    ACCOUNT_INFO_REQUEST(3),
    WORLD_INFO_REQUEST(4),
    SELECT_WORLD(5),
    CHECK_USER_LIMIT(6),
    CONFIRM_EULA(7),
    SET_GENDER(8),
    CHECK_PIN_CODE(9),
    UPDATE_PIN_CODE(10),
    WORLD_REQUEST(11),
    LOGOUT_WORLD(12),
    VIEW_ALL_CHAR(13),
    SELECT_CHARACTER_BY_VAC(14),
    VAC_FLAG_SET(15),
    CHECK_NAME_CHANGE_POSSIBLE(16),
    REGISTER_NEW_CHARACTER(17),
    CHECK_TRANSFER_WORLD_POSSIBLE(18),
    SELECT_CHARACTER(19),
    MIGRATE_IN(20),
    CHECK_DUPLICATED_ID(21),
    CREATE_NEW_CHARACTER(22),
    CREATE_NEW_CHARACTER_IN_CS(23),
    DELETE_CHARACTER(24),
    ALIVE_ACK(25),
    EXCEPTION_LOG(26),
    SECURITY_PACKET(27),
    ENABLE_SPW_REQUEST(28),
    CHECK_SPW_REQUEST(29),
    ENABLE_SPW_REQUEST_BY_VAC(30),
    CHECK_SPW_REQUEST_BY_VAC(31),
    CHECK_OTP_REQUEST(32),
    CHECK_DELETE_CHARACTER_OTP(33),
    CREATE_SECURITY_HANDLE(34),
    SSO_ERROR_LOG(35),
    CLIENT_DUMP_LOG(36),
    CHECK_EXTRA_CHAR_INFO(37),
    CREATE_NEW_CHARACTER_EX(38),
    // END_SOCKET(39),
    // BEGIN_USER(40),
    USER_TRANSFER_FIELD_REQUEST(41),
    USER_TRANSFER_CHANNEL_REQUEST(42),
    USER_MIGRATE_TO_CASHSHOP_REQUEST(43),
    USER_MOVE(44),
    USER_SIT_REQUEST(45),
    USER_PORTABLE_CHAIR_SIT_REQUEST(46),
    USER_MELEE_ATTACK(47),
    USER_SHOOT_ATTACK(48),
    USER_MAGIC_ATTACK(49),
    USER_BODY_ATTACK(50),
    USER_MOVING_SHOOT_ATTACK_PREPARE(51),
    USER_HIT(52),
    USER_ATTACK_USER(53),
    USER_CHAT(54),
    USER_AD_BOARD_CLOSE(55),
    USER_EMOTION(56),
    USER_ACTIVATE_EFFECT_ITEM(57),
    USER_UPGRADE_TOMB_EFFECT(58),
    USER_BAN_MAP_BY_MOB(61),
    USER_MONSTER_BOOK_SET_COVER(62),
    USER_SELECT_NPC(63),
    USER_REMOTE_SHOP_OPEN_REQUEST(64),
    USER_SCRIPT_MESSAGE_ANSWER(65),
    USER_SHOP_REQUEST(66),
    USER_TRUNK_REQUEST(67),
    USER_ENTRUSTED_SHOP_REQUEST(68),
    USER_STORE_BANK_REQUEST(69),
    USER_PARCEL_REQUEST(70),
    USER_EFFECT_LOCAL(71),
    SHOP_SCANNER_REQUEST(72),
    SHOP_LINK_REQUEST(73),
    ADMIN_SHOP_REQUEST(74),
    USER_GATHER_ITEM_REQUEST(75),
    USER_SORT_ITEM_REQUEST(76),
    USER_CHANGE_SLOT_POSITION_REQUEST(77),
    USER_STAT_CHANGE_ITEM_REQUEST(78),
    USER_STAT_CHANGE_ITEM_CANCEL_REQUEST(79),
    USER_STAT_CHANGE_BY_PORTABLE_CHAIR_REQUEST(80),
    USER_MOB_SUMMON_ITEM_USE_REQUEST(81),
    USER_PET_FOOD_ITEM_USE_REQUEST(82),
    USER_TAMING_MOB_FOOD_ITEM_USE_REQUEST(83),
    USER_SCRIPT_ITEM_USE_REQUEST(84),
    USER_CONSUME_CASH_ITEM_USE_REQUEST(85),
    USER_DESTROY_PET_ITEM_REQUEST(86),
    USER_BRIDLE_ITEM_USE_REQUEST(87),
    USER_SKILL_LEARN_ITEM_USE_REQUEST(88),
    USER_SKILL_RESET_ITEM_USE_REQUEST(89),
    USER_SHOP_SCANNER_ITEM_USE_REQUEST(90),
    USER_MAP_TRANSFER_ITEM_USE_REQUEST(91),
    USER_PORTAL_SCROLL_USE_REQUEST(92),
    USER_UPGRADE_ITEM_USE_REQUEST(93),
    USER_HYPER_UPGRADE_ITEM_USE_REQUEST(94),
    USER_ITEM_OPTION_UPGRADE_ITEM_USE_REQUEST(95),
    USER_UI_OPEN_ITEM_USE_REQUEST(96),
    USER_ITEM_RELEASE_REQUEST(97),
    USER_ABILITY_UP_REQUEST(98),
    USER_ABILITY_MASS_UP_REQUEST(99),
    USER_STAT_CHANGE_REQUEST(100),
    USER_STAT_CHANGE_REQUEST_BY_ITEM_OPTION(101),
    USER_SKILL_UP_REQUEST(102),
    USER_SKILL_USE_REQUEST(103),
    USER_SKILL_CANCEL_REQUEST(104),
    USER_SKILL_PREPARE_REQUEST(105),
    USER_DROP_MONEY_REQUEST(106),
    USER_GIVE_POPULARITY_REQUEST(107),
    USER_PARTY_REQUEST(108),
    USER_CHARACTER_INFO_REQUEST(109),
    USER_ACTIVATE_PET_REQUEST(110),
    USER_TEMPORARY_STAT_UPDATE_REQUEST(111),
    USER_PORTAL_SCRIPT_REQUEST(112),
    USER_PORTAL_TELEPORT_REQUEST(113),
    USER_MAP_TRANSFER_REQUEST(114),
    USER_ANTI_MACRO_ITEM_USE_REQUEST(115),
    USER_ANTI_MACRO_SKILL_USE_REQUEST(116),
    USER_ANTI_MACRO_QUESTION_RESULT(117),
    USER_CLAIM_REQUEST(118),
    USER_QUEST_REQUEST(119),
    USER_CALC_DAMAGE_STAT_SET_REQUEST(120),
    USER_THROW_GRENADE(121),
    USER_MACRO_SYS_DATA_MODIFIED(122),
    USER_SELECT_NPC_ITEM_USE_REQUEST(123),
    USER_LOTTERY_ITEM_USE_REQUEST(124),
    USER_ITEM_MAKER_REQUEST(125),
    USER_SUE_CHARACTER_REQUEST(126),
    USER_USE_GACHAPON_BOX_REQUEST(127),
    USER_USE_GACHAPON_REMOTE_REQUEST(128),
    USER_USE_WATER_OF_LIFE(129),
    USER_REPAIR_DURABILITY_ALL(130),
    USER_REPAIR_DURABILITY(131),
    USER_QUEST_RECORD_SET_STATE(132),
    USER_CLIENT_TIMER_END_REQUEST(133),
    USER_FOLLOW_CHARACTER_REQUEST(134),
    USER_FOLLOW_CHARACTER_WITHDRAW(135),
    USER_SELECT_PQ_REWARD(136),
    USER_REQUEST_PQ_REWARD(137),
    SET_PASSENSER_RESULT(138),
    BROADCAST_MSG(139),
    GROUP_MESSAGE(140),
    WHISPER(141),
    COUPLE_MESSAGE(142),
    MESSENGER(143),
    MINIROOM(144),
    PARTY_REQUEST(145),
    PARTY_RESULT(146),
    EXPEDITION_REQUEST(147),
    EXPEDITION_RESULT(148),
    GUILD_REQUEST(149),
    GUILD_RESULT(150),
    ADMIN(151),
    LOG(152),
    FRIEND_REQUEST(153),
    MEMO_REQUEST(154),
    ENTER_TOWN_PORTAL_REQUEST(156),
    ENTER_OPEN_GATE_REQUEST(157),
    SLIDE_REQUEST(158),
    FUNC_KEY_MAPPED_MODIFIED(159),
    RPS_GAME(160),
    MARRIAGE_REQUEST(161),
    WEDDING_WISH_LIST_REQUEST(162),
    WEDDING_PROGRESS(163),
    GUEST_BLESS(164),
    BOOBY_TRAP_ALERT(165),
    STALK_BEGIN(166),
    ALLIANCE_REQUEST(167),
    ALLiANCE_RESULT(168),
    FAMILY_CHART_REQUEST(169),
    FAMILY_INFO_REQUEST(170),
    FAMILY_REGISTER_JUNIOR(171),
    FAMILY_UNREGISTER_JUNIOR(172),
    FAMILY_UNREGISTER_PARENT(173),
    FAMILY_JOIN_RESULT(174),
    FAMILY_USE_PRIVILEGE(175),
    FAMILY_SET_PRECEPT(176),
    FAMILY_SUMMON_RESULT(177),
    CHAT_BLOCK_USER_REQ(178),
    GUILD_BBS(179),
    USER_MIGRATE_TO_ITC_REQUEST(180),
    USER_EXP_UP_ITEM_USE_REQUEST(181),
    USER_TEMP_EXP_USE_REQUEST(182),
    NEW_YEAR_CARD_REQUEST(183),
    RANDOM_MORPH_REQUEST(184),
    CASH_ITEM_GACHAPON_REQUEST(185),
    CASH_GACHAPON_OPEN_REQUEST(186),
    CHANGE_MAPLE_POINT_REQUEST(187),
    TALK_TO_TUTOR(188),
    REQUEST_INC_COMBO(189),
    MOB_CRC_KEY_CHANGED_REPLY(190),
    REQUEST_SESSION_VALUE(191),
    UPDATE_GM_BOARD(192),
    ACCOUNT_MORE_INFO(193),
    FIND_FRIEND(194),
    ACCEPT_APSP_EVENT(195),
    USER_DRAGON_BALL_BOX_REQUEST(196),
    USER_DRAGON_BALL_SUMMON_REQUEST(197),
    // BEGIN_PET(198),
    PET_MOVE(199),
    PET_ACTION(200),
    PET_INTERACTION_REQUEST(201),
    PET_DROP_PICK_UP_REQUEST(202),
    PET_STAT_CHANGE_ITEM_USE_REQUEST(203),
    PET_UPDATE_EXCEPTION_LIST_REQUEST(204),
    // END_PET(205),
    // BEGIN_SUMMONED(206),
    SUMMONED_MOVE(207),
    SUMMONED_ATTACK(208),
    SUMMONED_HIT(209),
    SUMMONED_SKILL(210),
    SUMMONED_REMOVE(211),
    // END_SUMMONED(212),
    // BEGIN_DRAGON(213),
    DRAGON_MOVE(214),
    // END_DRAGON(215),
    QUICKSLOT_KEY_MAPPED_MODIFIED(216),
    PASSIVE_SKILL_INFO_UPDATE(217),
    UPDATE_SCREEN_SETTING(218),
    USER_ATTACK_USER_SPECIFIC(219),
    USER_PAMS_SONG_USE_REQUEST(220),
    QUEST_GUIDE_REQUEST(221),
    USER_REPEAT_EFFECT_REMOVE(222),
    // END_USER(223),
    // BEGIN_FIELD(224),
    // BEGIN_LIFEPOOL(225),
    // BEGIN_MOB(226),
    MOB_MOVE(227),
    MOB_APPLY_CTRL(228),
    MOB_DROP_PICK_UP_REQUEST(229),
    MOB_HIT_BY_OBSTACLE(230),
    MOB_HIT_BY_MOB(231),
    MOB_SELF_DESTRUCT(232),
    MOB_ATTACK_MOB(233),
    MOB_SKILL_DELAY_END(234),
    MOB_TIME_BOMB_END(235),
    MOB_ESCORT_COLLISION(236),
    MOB_REQUEST_ESCORT_INFO(237),
    MOB_ESCORT_STOP_END_REQUEST(238),
    // END_MOB(239),
    // BEGIN_NPC(240),
    NPC_MOVE(241),
    NPC_SPECIAL_ACTION(242),
    // END_NPC(243),
    // END_LIFEPOOL(244),
    // BEGIN_DROPPOOL(245),
    DROP_PICK_UP_REQUEST(246),
    // END_DROPPOOL(247),
    // BEGIN_REACTORPOOL(248),
    REACTOR_HIT(249),
    REACTOR_TOUCH(250),
    REQUIRE_FIELD_OBSTACLE_STATUS(251),
    // END_REACTORPOOL(252),
    // BEGIN_EVENT_FIELD(253),
    EVENT_START(254),
    SNOW_BALL_HIT(255),
    SNOW_BALL_TOUCH(256),
    COCONUT_HIT(257),
    TOURNAMENT_MATCH_TABLE(258),
    PULLEY_HIT(259),
    // END_EVENT_FIELD(260),
    // BEGIN_MONSTER_CARNIVAL_FIELD(261),
    MONSTER_CARNIVAL_REQUEST(262),
    // END_MONSTER_CARNIVAL_FIELD(263),
    CONTI_STATE(264),
    // BEGIN_PARTY_MATCH(265),
    INVITE_PARTY_MATCH(266),
    CANCEL_INVITE_PARTY_MATCH(267),
    // END_PARTY_MATCH(268),
    REQUEST_FOOTHOLD_INFO(269),
    FOOTHOLD_INFO(270),
    // END_FIELD(271),
    // BEGIN_CASHSHOP(272),
    CASHSHOP_CHARGE_PARAM_REQUEST(273),
    CASHSHOP_QUERY_CASH_REQUEST(274),
    CASHSHOP_CASH_ITEM_REQUEST(275),
    CASHSHOP_CHECK_COUPON_REQUEST(276),
    CASHSHOP_GIFT_MATE_INFO_REQUEST(277),
    // END_CASHSHOP(278),
    CHECK_SSN2_ON_CREATE_NEW_CHARACTER(279),
    CHECK_SPW_ON_CREATE_NEW_CHARACTER(280),
    FIRST_SSN_ON_CREATE_NEW_CHARACTER(281),
    // BEGIN_RAISE(282),
    RAISE_REFRESH(283),
    RAISE_UI_STATE(284),
    RAISE_INC_EXP(285),
    RAISE_ADD_PIECE(286),
    // END_RAISE(287),
    SEND_MATE_MAIL(288),
    REQUEST_GUILD_BOARD_AUTH_KEY(289),
    REQUEST_CONSULT_AUTH_KEY(290),
    REQUEST_CLASS_COMPETITION_AUTH_KEY(291),
    REQUEST_WEB_BOARD_AUTH_KEY(292),
    // BEGIN_ITEMUPGRADE(293),
    GOLD_HAMMER_REQUEST(294),
    GOLD_HAMMER_COMPLETE(295),
    ITEM_UPGRADE_COMPLETE(296),
    // END_ITEMUPGRADE(297),
    // BEGIN_BATTLERECORD(298),
    BATTLERECORD_ONOFF_REQUEST(299),
    // END_BATTLERECORD(300)
    // BEGIN_MAPLETV(301),
    MAPLE_TV_SEND_MESSAGE_REQUEST(302),
    MAPLE_TV_UPDATE_VIEW_COUNT(303),
    // END_MAPLETV(304),
    // BEGIN_ITC(305),
    ITC_CHARGE_PARAM_REQUEST(306),
    ITC_QUERY_CASH_REQUEST(307),
    ITC_ITEM_REQUEST(308),
    // END_ITC(309),
    // BEGIN_CHARACTERSALE(310),
    CHECK_DUPLICATED_ID_IN_CS(311),
    // END_CHARACTERSALE(312),
    LOGOUT_GIFT_SELECT(313),
    NO(314);

    private static final Map<Short, InHeader> headerMap;
    private static final Set<InHeader> ignoreHeaders;

    static {
        headerMap = new HashMap<>();
        for (InHeader header : values()) {
            headerMap.put(header.getValue(), header);
        }
        ignoreHeaders = Set.of(
                CREATE_SECURITY_HANDLE,
                UPDATE_SCREEN_SETTING,
                USER_MOVE,
                USER_EMOTION,
                MOB_MOVE,
                MOB_APPLY_CTRL,
                NPC_MOVE
        );
    }

    private final short value;

    InHeader(int value) {
        this.value = (short) value;
    }

    public final short getValue() {
        return value;
    }

    public final boolean isIgnoreHeader() {
        return ignoreHeaders.contains(this);
    }

    public static InHeader getByValue(short op) {
        return headerMap.get(op);
    }
}
