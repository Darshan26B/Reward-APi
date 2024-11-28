package com.example.apifetch_23_09.Class

import android.content.Context
import android.content.Intent
import com.example.apifetch_23_09.Activity.SecondActivity

class RequestClass {

    fun getScreen(context: Context,screenNo:String) {

        when(screenNo)  {
            "8" -> {
                val intent = Intent(context, SecondActivity::class.java)
                context.startActivity(intent)
            }
            "63" -> {
                val intent = Intent(context, SecondActivity::class.java)
                context.startActivity(intent)
            }

        }

    }
}