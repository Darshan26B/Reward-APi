package com.example.apifetch_23_09.Adapter

import android.util.Log
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

class SingleSliderAdapter(var mainActivity: MainActivity, var singleSList: List<Data>) :
    RecyclerView.Adapter<SingleSliderAdapter.SingleSliderViewHolder>() {

    class SingleSliderViewHolder(itemView: View) : ViewHolder(itemView) {
        var singleS = itemView.findViewById<ImageView>(R.id.img_SingleS)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleSliderViewHolder {
        val view =
            LayoutInflater.from(mainActivity).inflate(R.layout.singleslider_itemview, parent, false)
        return SingleSliderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return singleSList.size
        Log.e("=======", "getItemCount: ${singleSList.size}", )
    }

    override fun onBindViewHolder(holder: SingleSliderViewHolder, position: Int) {
        Log.e("=======", "getItemCount: ${singleSList[position].image}", )
        Glide.with(mainActivity).load(singleSList[position].image).into(holder.singleS)
    }
}