package com.example.apifetch_23_09.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apifetch_23_09.Activity.MainActivity
import com.example.apifetch_23_09.Model.Data
import com.example.apifetch_23_09.R

class singleBigTaskAdapter(var mainActivity: MainActivity, var singleBigTaskList: List<Data>):RecyclerView.Adapter<singleBigTaskAdapter.singleBigTaskHolder>() {

    class singleBigTaskHolder(itemView: View) :ViewHolder(itemView) {
        var singleTask = itemView.findViewById<ImageView>(R.id.img_SingleTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): singleBigTaskHolder {
        val view =
            LayoutInflater.from(mainActivity).inflate(R.layout.singlebigtask_itemview, parent, false)
        return singleBigTaskHolder(view)
    }

    override fun getItemCount(): Int {
        return singleBigTaskList.size
    }

    override fun onBindViewHolder(holder: singleBigTaskHolder, position: Int) {
        Glide.with(mainActivity).load(singleBigTaskList[position].images).into(holder.singleTask)
    }


}