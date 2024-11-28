package com.example.apifetch_23_09.Model


import GridData
import com.google.gson.annotations.SerializedName

data class MainData(


    @SerializedName("bgColor")
    var bgColor: String,
    @SerializedName("columnCount")
    var columnCount: String,
    @SerializedName("data")
    var data: MutableList<Data>?,
    @SerializedName("displayImage")
    var displayImage: String,
    @SerializedName("gridData")
    var gridData: List<GridData>?,
    @SerializedName("icon")
    var icon: String,
    @SerializedName("iconBGColor")
    var iconBGColor: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("isActive")
    var isActive: String,
    @SerializedName("isBorder")
    var isBorder: String,
    @SerializedName("isTodayTaskCompleted")
    var isTodayTaskCompleted: String,
    @SerializedName("isViewAll")
    var isViewAll: String,
    @SerializedName("note")
    var note: String,
    @SerializedName("pointBackgroundColor")
    var pointBackgroundColor: String,
    @SerializedName("pointTextColor")
    var pointTextColor: String,
    @SerializedName("screenNo")
    var screenNo: String,
    @SerializedName("subTitle")
    var subTitle: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("url")
    var url: String,

    ) {
    constructor(
        type: String,
        gridData: MutableList<GridData>,
        data: MutableList<Data>,
    ) : this(
        "",
        "",
        data,
        "",
        gridData,
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        type,
        ""
    )
}
