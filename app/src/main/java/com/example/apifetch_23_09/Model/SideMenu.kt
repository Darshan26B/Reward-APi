package com.example.apifetch_23_09.Model


import com.google.gson.annotations.SerializedName

data class SideMenu(
    @SerializedName("gameId")
    var gameId: String,
    @SerializedName("icon")
    var icon: String,
    @SerializedName("isBlink")
    var isBlink: String,
    @SerializedName("isLoginNeed")
    var isLoginNeed: String,
    @SerializedName("label")
    var label: String,
    @SerializedName("labelBGColor")
    var labelBGColor: String,
    @SerializedName("labelColor")
    var labelColor: String,
    @SerializedName("offerId")
    var offerId: String,
    @SerializedName("screenNo")
    var screenNo: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("titleColor")
    var titleColor: String,
    @SerializedName("url")
    var url: String
)