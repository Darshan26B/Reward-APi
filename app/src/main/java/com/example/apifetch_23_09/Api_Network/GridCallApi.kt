package com.example.apifetch_23_09.Class

import android.util.Log
import com.example.apifetch_23_09.Activity.MainActivity
import com.example.apifetch_23_09.Api_Network.Api_Client
import com.example.apifetch_23_09.Model.GridDataModel
 import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GridCallApi(mainActivity: MainActivity) {

//    private val dbHelper: DatabaseHelper = DatabaseHelper(mainActivity)

    init {
        try {
            Api_Client().retrofit_client().getGrid().enqueue(object : Callback<GridDataModel> {
                override fun onResponse(p0: Call<GridDataModel>, response: Response<GridDataModel>) {
                        mainActivity.setdata(mainActivity, response)
                    Log.d("response===", "onResponse: "+response)
                }

                override fun onFailure(p0: Call<GridDataModel>, p1: Throwable) {
                    Log.e("GridCallApi", "API call failed: ${p1.message}")
                }
            })

        } catch (e: Exception) {
            Log.e("GridCallApi", "Error in API call: ${e.message}")
        }
    }


}
