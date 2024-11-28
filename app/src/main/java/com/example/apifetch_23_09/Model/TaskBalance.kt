package com.example.apifetch_23_09.Model

import com.google.gson.annotations.SerializedName

data class TaskBalance(
    @SerializedName("description")
    var description: String,
    @SerializedName("endDate")
    var endDate: String,
    @SerializedName("icon")
    var icon: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("isTaskBalanceDialog")
    var isTaskBalanceDialog: String,
    @SerializedName("points")
    var points: String,
    @SerializedName("screenNo")
    var screenNo: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String
)