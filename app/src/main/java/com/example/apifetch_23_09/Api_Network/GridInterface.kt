package com.example.apifetch_23_09.Api_Network

import com.example.apifetch_23_09.Model.GridDataModel
import retrofit2.Call
import retrofit2.http.POST

interface GridInterface {

    @POST("JENNA")
    fun getGrid(): Call<GridDataModel>
}