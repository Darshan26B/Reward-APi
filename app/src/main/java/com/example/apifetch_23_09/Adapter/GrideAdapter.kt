package com.example.apifetch_23_09.Adapter

import GridData
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apifetch_23_09.Activity.MainActivity
 import com.example.apifetch_23_09.R

class GrideAdapter(
    var mainActivity: MainActivity,
    var gridList: List<GridData>,
    private val listener: OnItemClickListener,
) : RecyclerView.Adapter<GrideAdapter.GridHolder>() {

    class GridHolder(itemView: View) : ViewHolder(itemView) {
        var grideImage = itemView.findViewById<ImageView>(R.id.img_gridItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHolder {
        val view = LayoutInflater.from(mainActivity).inflate(R.layout.gride_itemview, parent, false)
        return GridHolder(view)
    }

    override fun getItemCount(): Int {
        return gridList.size
    }

    override fun onBindViewHolder(holder: GridHolder, position: Int) {
        Glide.with(mainActivity).load(gridList[position].fullImage).into(holder.grideImage)
        Log.d("Image====", "onBindViewHolder: "+gridList[position].fullImage)

        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}