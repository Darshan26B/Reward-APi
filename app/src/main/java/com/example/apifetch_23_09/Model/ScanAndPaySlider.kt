package com.example.apifetch_23_09.Model


import com.google.gson.annotations.SerializedName

data class ScanAndPaySlider(
    @SerializedName("image")
    var image: String,
    @SerializedName("screenNo")
    var screenNo: String,
    @SerializedName("url")
    var url: String
)