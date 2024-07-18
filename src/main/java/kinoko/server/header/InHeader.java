package kinoko.server.header;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum InHeader {
    // CP
    // BEGIN_SOCKET(0),
    CheckPassword(1),
    GuestIDLogin(2),
    AccountInfoRequest(3),
    WorldInfoRequest(4),
    SelectWorld(5),
    CheckUserLimit(6),
    ConfirmEULA(7),
    SetGender(8),
    CheckPinCode(9),
    UpdatePinCode(10),
    WorldRequest(11),
    LogoutWorld(12),
    ViewAllChar(13),
    SelectCharacterByVAC(14),
    VACFlagSet(15),
    CheckNameChangePossible(16),
    RegisterNewCharacter(17),
    CheckTransferWorldPossible(18),
    SelectCharacter(19),
    MigrateIn(20),
    CheckDuplicatedID(21),
    CreateNewCharacter(22),
    CreateNewCharacterInCS(23),
    DeleteCharacter(24),
    AliveAck(25),
    ExceptionLog(26),
    SecurityPacket(27),
    EnableSPWRequest(28),
    CheckSPWRequest(29),
    EnableSPWRequestByACV(30),
    CheckSPWRequestByACV(31),
    CheckOTPRequest(32),
    CheckDeleteCharacterOTP(33),
    CreateSecurityHandle(34),
    SSOErrorLog(35),
    ClientDumpLog(36),
    CheckExtraCharInfo(37),
    CreateNewCharacter_Ex(38),
    // END_SOCKET(39),
    // BEGIN_USER(40),
    UserTransferFieldRequest(41),
    UserTransferChannelRequest(42),
    UserMigrateToCashShopRequest(43),
    UserMove(44),
    UserSitRequest(45),
    UserPortableChairSitRequest(46),
    UserMeleeAttack(47),
    UserShootAttack(48),
    UserMagicAttack(49),
    UserBodyAttack(50),
    UserMovingShootAttackPrepare(51),
    UserHit(52),
    UserAttackUser(53),
    UserChat(54),
    UserADBoardClose(55),
    UserEmotion(56),
    UserActivateEffectItem(57),
    UserUpgradeTombEffect(58),
    UserHP(59),
    Premium(60),
    UserBanMapByMob(61),
    UserMonsterBookSetCover(62),
    UserSelectNpc(63),
    UserRemoteShopOpenRequest(64),
    UserScriptMessageAnswer(65),
    UserShopRequest(66),
    UserTrunkRequest(67),
    UserEntrustedShopRequest(68),
    UserStoreBankRequest(69),
    UserParcelRequest(70),
    UserEffectLocal(71),
    ShopScannerRequest(72),
    ShopLinkRequest(73),
    AdminShopRequest(74),
    UserGatherItemRequest(75),
    UserSortItemRequest(76),
    UserChangeSlotPositionRequest(77),
    UserStatChangeItemUseRequest(78),
    UserStatChangeItemCancelRequest(79),
    UserStatChangeByPortableChairRequest(80),
    UserMobSummonItemUseRequest(81),
    UserPetFoodItemUseRequest(82),
    UserTamingMobFoodItemUseRequest(83),
    UserScriptItemUseRequest(84),
    UserConsumeCashItemUseRequest(85),
    UserDestroyPetItemRequest(86),
    UserBridleItemUseRequest(87),
    UserSkillLearnItemUseRequest(88),
    UserSkillResetItemUseRequest(89),
    UserShopScannerItemUseRequest(90),
    UserMapTransferItemUseRequest(91),
    UserPortalScrollUseRequest(92),
    UserUpgradeItemUseRequest(93),
    UserHyperUpgradeItemUseRequest(94),
    UserItemOptionUpgradeItemUseRequest(95),
    UserUIOpenItemUseRequest(96),
    UserItemReleaseRequest(97),
    UserAbilityUpRequest(98),
    UserAbilityMassUpRequest(99),
    UserChangeStatRequest(100),
    UserChangeStatRequestByItemOption(101),
    UserSkillUpRequest(102),
    UserSkillUseRequest(103),
    UserSkillCancelRequest(104),
    UserSkillPrepareRequest(105),
    UserDropMoneyRequest(106),
    UserGivePopularityRequest(107),
    UserPartyRequest(108),
    UserCharacterInfoRequest(109),
    UserActivatePetRequest(110),
    UserTemporaryStatUpdateRequest(111),
    UserPortalScriptRequest(112),
    UserPortalTeleportRequest(113),
    UserMapTransferRequest(114),
    UserAntiMacroItemUseRequest(115),
    UserAntiMacroSkillUseRequest(116),
    UserAntiMacroQuestionResult(117),
    UserClaimRequest(118),
    UserQuestRequest(119),
    UserCalcDamageStatSetRequest(120),
    UserThrowGrenade(121),
    UserMacroSysDataModified(122),
    UserSelectNpcItemUseRequest(123),
    UserLotteryItemUseRequest(124),
    UserItemMakeRequest(125),
    UserSueCharacterRequest(126),
    UserUseGachaponBoxRequest(127),
    UserUseGachaponRemoteRequest(128),
    UserUseWaterOfLife(129),
    UserRepairDurabilityAll(130),
    UserRepairDurability(131),
    UserQuestRecordSetState(132),
    UserClientTimerEndRequest(133),
    UserFollowCharacterRequest(134),
    UserFollowCharacterWithdraw(135),
    UserSelectPQReward(136),
    UserRequestPQReward(137),
    SetPassenserResult(138),
    BroadcastMsg(139),
    GroupMessage(140),
    Whisper(141),
    CoupleMessage(142),
    Messenger(143),
    MiniRoom(144),
    PartyRequest(145),
    PartyResult(146),
    ExpeditionRequest(147),
    PartyAdverRequest(148),
    GuildRequest(149),
    GuildResult(150),
    Admin(151),
    Log(152),
    FriendRequest(153),
    MemoRequest(154),
    MemoFlagRequest(155),
    EnterTownPortalRequest(156),
    EnterOpenGateRequest(157),
    SlideRequest(158),
    FuncKeyMappedModified(159),
    RPSGame(160),
    MarriageRequest(161),
    WeddingWishListRequest(162),
    WeddingProgress(163),
    GuestBless(164),
    BoobyTrapAlert(165),
    StalkBegin(166),
    AllianceRequest(167),
    AllianceResult(168),
    FamilyChartRequest(169),
    FamilyInfoRequest(170),
    FamilyRegisterJunior(171),
    FamilyUnregisterJunior(172),
    FamilyUnregisterParent(173),
    FamilyJoinResult(174),
    FamilyUsePrivilege(175),
    FamilySetPrecept(176),
    FamilySummonResult(177),
    ChatBlockUserReq(178),
    GuildBBS(179),
    UserMigrateToITCRequest(180),
    UserExpUpItemUseRequest(181),
    UserTempExpUseRequest(182),
    NewYearCardRequest(183),
    RandomMorphRequest(184),
    CashItemGachaponRequest(185),
    CashGachaponOpenRequest(186),
    ChangeMaplePointRequest(187),
    TalkToTutor(188),
    RequestIncCombo(189),
    MobCrcKeyChangedReply(190),
    RequestSessionValue(191),
    UpdateGMBoard(192),
    AccountMoreInfo(193),
    FindFriend(194),
    AcceptAPSPEvent(195),
    UserDragonBallBoxRequest(196),
    UserDragonBallSummonRequest(197),
    // BEGIN_PET(198),
    PetMove(199),
    PetAction(200),
    PetInteractionRequest(201),
    PetDropPickUpRequest(202),
    PetStatChangeItemUseRequest(203),
    PetUpdateExceptionListRequest(204),
    // END_PET(205),
    // BEGIN_SUMMONED(206),
    SummonedMove(207),
    SummonedAttack(208),
    SummonedHit(209),
    SummonedSkill(210),
    SummonedRemove(211), // CP_Remove
    // END_SUMMONED(212),
    // BEGIN_DRAGON(213),
    DragonMove(214),
    // END_DRAGON(215),
    QuickslotKeyMappedModified(216),
    PassiveskillInfoUpdate(217),
    UpdateScreenSetting(218),
    UserAttackUser_Specific(219),
    UserPamsSongUseRequest(220),
    QuestGuideRequest(221),
    UserRepeatEffectRemove(222),
    // END_USER(223),
    // BEGIN_FIELD(224),
    // BEGIN_LIFEPOOL(225),
    // BEGIN_MOB(226),
    MobMove(227),
    MobApplyCtrl(228),
    MobDropPickUpRequest(229),
    MobHitByObstacle(230),
    MobHitByMob(231),
    MobSelfDestruct(232),
    MobAttackMob(233),
    MobSkillDelayEnd(234),
    MobTimeBombEnd(235),
    MobEscortCollision(236),
    MobRequestEscortInfo(237),
    MobEscortStopEndRequest(238),
    // END_MOB(239),
    // BEGIN_NPC(240),
    NpcMove(241),
    NpcSpecialAction(242),
    // END_NPC(243),
    // END_LIFEPOOL(244),
    // BEGIN_DROPPOOL(245),
    DropPickUpRequest(246),
    // END_DROPPOOL(247),
    // BEGIN_REACTORPOOL(248),
    ReactorHit(249),
    ReactorTouch(250),
    RequireFieldObstacleStatus(251),
    // END_REACTORPOOL(252),
    // BEGIN_EVENT_FIELD(253),
    EventStart(254),
    SnowBallHit(255),
    SnowBallTouch(256),
    CoconutHit(257),
    TournamentMatchTable(258),
    PulleyHit(259),
    // END_EVENT_FIELD(260),
    // BEGIN_MONSTER_CARNIVAL_FIELD(261),
    MCarnivalRequest(262),
    // END_MONSTER_CARNIVAL_FIELD(263),
    CONTISTATE(264),
    // BEGIN_PARTY_MATCH(265),
    INVITE_PARTY_MATCH(266),
    CANCEL_INVITE_PARTY_MATCH(267),
    // END_PARTY_MATCH(268),
    RequestFootHoldInfo(269),
    FootHoldInfo(270),
    // END_FIELD(271),
    // BEGIN_CASHSHOP(272),
    CashShopChargeParamRequest(273),
    CashShopQueryCashRequest(274),
    CashShopCashItemRequest(275),
    CashShopCheckCouponRequest(276),
    CashShopGiftMateInfoRequest(277),
    // END_CASHSHOP(278),
    CheckSSN2OnCreateNewCharacter(279),
    CheckSPWOnCreateNewCharacter(280),
    FirstSSNOnCreateNewCharacter(281),
    // BEGIN_RAISE(282),
    RaiseRefesh(283),
    RaiseUIState(284),
    RaiseIncExp(285),
    RaiseAddPiece(286),
    // END_RAISE(287),
    SendMateMail(288),
    RequestGuildBoardAuthKey(289),
    RequestConsultAuthKey(290),
    RequestClassCompetitionAuthKey(291),
    RequestWebBoardAuthKey(292),
    // BEGIN_ITEMUPGRADE(293),
    GoldHammerRequest(294),
    GoldHammerComplete(295),
    ItemUpgradeComplete(296),
    // END_ITEMUPGRADE(297),
    // BEGIN_BATTLERECORD(298),
    BATTLERECORD_ONOFF_REQUEST(299),
    // END_BATTLERECORD(300),
    // BEGIN_MAPLETV(301),
    MapleTVSendMessageRequest(302),
    MapleTVUpdateViewCount(303),
    // END_MAPLETV(304),
    // BEGIN_ITC(305),
    ITCChargeParamRequest(306),
    ITCQueryCashRequest(307),
    ITCItemRequest(308),
    // END_ITC(309),
    // BEGIN_CHARACTERSALE(310),
    CheckDuplicatedIDInCS(311),
    // END_CHARACTERSALE(312),
    LogoutGiftSelect(313),
    NO(314);

    private static final List<InHeader> headers;
    private static final Set<InHeader> ignoreHeaders = Set.of(
            CreateSecurityHandle,
            UpdateScreenSetting,
            FuncKeyMappedModified,
            QuickslotKeyMappedModified,
            UserMove,
            UserEmotion,
            UserChangeStatRequest,
            RequestIncCombo,
            PetMove,
            PetAction,
            DragonMove,
            SummonedMove,
            MobMove,
            MobApplyCtrl,
            NpcMove,
            CANCEL_INVITE_PARTY_MATCH
    );

    static {
        final List<InHeader> headerList = new ArrayList<>(Collections.nCopies(NO.getValue() + 1, null));
        for (InHeader header : values()) {
            headerList.set(header.getValue(), header);
        }
        headers = Collections.unmodifiableList(headerList);
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
        if (op >= 0 && op < NO.getValue()) {
            return headers.get(op);
        }
        return null;
    }
}
