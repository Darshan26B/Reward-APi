package com.example.apifetch_23_09.Adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apifetch_23_09.Activity.MainActivity
 import com.example.apifetch_23_09.Model.Data
import com.example.apifetch_23_09.R

class QuicktaskAdapter(var mainActivity: MainActivity, var Quicktask: List<Data>) :
    RecyclerView.Adapter<QuicktaskAdapter.QuicktaskHolder>() {

    class QuicktaskHolder(itemView: View) : ViewHolder(itemView) {
        var quickimg = itemView.findViewById<ImageView>(R.id.img_quickTask)
        var quickitle = itemView.findViewById<TextView>(R.id.quickTaskName)
        var quickdecription = itemView.findViewById<TextView>(R.id.quickTaskdescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuicktaskHolder {
        val view =
            LayoutInflater.from(mainActivity).inflate(R.layout.quicktask_itemview, parent, false)
        return QuicktaskHolder(view)
    }

    override fun getItemCount(): Int {
        return Quicktask.size
    }

    override fun onBindViewHolder(holder: QuicktaskHolder, position: Int) {
        holder.quickitle.text = Quicktask[position].title
        holder.quickdecription.text = Quicktask[position].description
        Glide.with(mainActivity).load(Quicktask[position].icon).into(holder.quickimg)

        holder.itemView.setOnClickListener {
            val url = Quicktask[position].url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            mainActivity.startActivity(intent)
        }
    }
}