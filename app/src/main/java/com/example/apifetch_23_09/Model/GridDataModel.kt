package com.example.apifetch_23_09.Model

import com.google.gson.annotations.SerializedName

data class GridDataModel(
    @SerializedName("abc")
    var abc: String,
    @SerializedName("adFailUrl")
    var adFailUrl: String,
    @SerializedName("adjoeKeyHash")
    var adjoeKeyHash: String,
    @SerializedName("appPrizeTargetCountryLocale")
    var appPrizeTargetCountryLocale: String,
    @SerializedName("appUrl")
    var appUrl: String,
    @SerializedName("appVersion")
    var appVersion: String,
    @SerializedName("celebrationLottieUrl")
    var celebrationLottieUrl: String,
    @SerializedName("earningPoint")
    var earningPoint: Any,
    @SerializedName("encrypt")
    var encrypt: String,
    @SerializedName("fakeEarningPoint")
    var fakeEarningPoint: String,
    @SerializedName("footerTaskIcon")
    var footerTaskIcon: String,
    @SerializedName("giveawayCode")
    var giveawayCode: String,
    @SerializedName("hotOffersScreenNo")
    var hotOffersScreenNo: String,
    @SerializedName("instagramUrl")
    var instagramUrl: String,
    @SerializedName("isAppLovinAdShow")
    var isAppLovinAdShow: String,
    @SerializedName("isForceUpdate")
    var isForceUpdate: String,
    @SerializedName("isScanAndPayShow")
    var isScanAndPayShow: String,
    @SerializedName("isShowAccountDeleteOption")
    var isShowAccountDeleteOption: String,
    @SerializedName("isShowAdjoeLeaderboardIcon")
    var isShowAdjoeLeaderboardIcon: String,
    @SerializedName("isShowAdjump")
    var isShowAdjump: String,
    @SerializedName("isShowAppPrize")
    var isShowAppPrize: String,
    @SerializedName("isShowFooterTaskIcon")
    var isShowFooterTaskIcon: String,
    @SerializedName("isShowGiveawayCode")
    var isShowGiveawayCode: String,
    @SerializedName("isShowHotOffers")
    var isShowHotOffers: String,
    @SerializedName("isShowOfferToro")
    var isShowOfferToro: String,
    @SerializedName("isShowPlaytimeSDK")
    var isShowPlaytimeSDK: String,
    @SerializedName("isShowPubScale")
    var isShowPubScale: String,
    @SerializedName("isShowWelcomeBonusPopup")
    var isShowWelcomeBonusPopup: String,
    @SerializedName("isShowWhatsAppAuth")
    var isShowWhatsAppAuth: String,
    @SerializedName("isTaskVisible")
    var isTaskVisible: String,
    @SerializedName("lovinAppOpenID")
    var lovinAppOpenID: List<String>,
    @SerializedName("lovinBannerID")
    var lovinBannerID: List<String>,
    @SerializedName("lovinInterstitialID")
    var lovinInterstitialID: List<String>,
    @SerializedName("lovinNativeID")
    var lovinNativeID: List<String>,
    @SerializedName("lovinRewardID")
    var lovinRewardID: List<String>,
    @SerializedName("lovinSmallNativeID")
    var lovinSmallNativeID: List<String>,
    @SerializedName("mainDataList")
    var mainDataList: List<MainData>,
    @SerializedName("message")
    var message: String,
    @SerializedName("nextWithdrawAmount")
    var nextWithdrawAmount: String,
    @SerializedName("offer_id")
    var offerId: String,
    @SerializedName("offerToroAppId")
    var offerToroAppId: String,
    @SerializedName("OfferToroSecretKey")
    var offerToroSecretKey: String,
    @SerializedName("packageInstallTrackingUrl")
    var packageInstallTrackingUrl: String,
    @SerializedName("pid")
    var pid: String,
    @SerializedName("pointValue")
    var pointValue: String,
    @SerializedName("poweredByScanAndImage")
    var poweredByScanAndImage: String,
    @SerializedName("privacyPolicy")
    var privacyPolicy: String,
    @SerializedName("scanAndPaySlider")
    var scanAndPaySlider: List<ScanAndPaySlider>,
    @SerializedName("sideMenuList")
    var sideMenuList: List<SideMenu>,
    @SerializedName("status")
    var status: String,
    @SerializedName("taskBalance")
    var taskBalance: TaskBalance,
    @SerializedName("telegramUrl")
    var telegramUrl: String,
    @SerializedName("termsConditionUrl")
    var termsConditionUrl: String,
    @SerializedName("todayDate")
    var todayDate: String,
    @SerializedName("updateMessage")
    var updateMessage: String,
    @SerializedName("welcomeBonus")
    var welcomeBonus: String,
    @SerializedName("youtubeUrl")
    var youtubeUrl: String
)