package com.example.apifetch_23_09.Model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("bgColor")
    var bgColor: String="",
    @SerializedName("btnColor")
    var btnColor: String="",
    @SerializedName("btnName")
    var btnName: String="",
    @SerializedName("btnTextColor")
    var btnTextColor: String="",
    @SerializedName("delay")
    var delay: String="",
    @SerializedName("description")
    var description: String="",
    @SerializedName("descriptionTextColor")
    var descriptionTextColor: String="",
    @SerializedName("displayImage")
    var displayImage: String="",
    @SerializedName("entryDate")
    var entryDate: String="",
    @SerializedName("icon")
    var icon: String="",
    @SerializedName("id")
    var id: String="",
    @SerializedName("image")
    var image: String="",
    @SerializedName("images")
    var images: String="",
    @SerializedName("isBlink")
    var isBlink: String="",
    @SerializedName("isNewLable")
    var isNewLable: String="",
    @SerializedName("isShareTask")
    var isShareTask: String="",
    @SerializedName("isShowBanner")
    var isShowBanner: String="",
    @SerializedName("label")
    var label: String="",
    @SerializedName("labelBgColor")
    var labelBgColor: String="",
    @SerializedName("labelTextColor")
    var labelTextColor: String="",
    @SerializedName("points")
    var points: String="",
    @SerializedName("screenNo")
    var screenNo: String="",
    @SerializedName("ShareTaskPoint")
    var shareTaskPoint: String="",
    @SerializedName("status")
    var status: String="",
    @SerializedName("tagList")
    var tagList: String="",
    @SerializedName("title")
    var title: String="",
    @SerializedName("titleTextColor")
    var titleTextColor: String="",
    @SerializedName("type")
    var type: String="",
    @SerializedName("url")
    var url: String=""
)