package com.example.apifetch_23_09.Api_Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api_Client {

    lateinit var retrofit: Retrofit

    fun retrofit_client(): GridInterface {
        retrofit = Retrofit.Builder()
            .baseUrl("http://eazyearning.com/Api/api100/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GridInterface::class.java)
    }
}