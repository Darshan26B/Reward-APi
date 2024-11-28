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

class taskListAdapter(var mainActivity: MainActivity, var taskList: List<Data>):RecyclerView.Adapter<taskListAdapter.taskListHolder>() {

    class taskListHolder(itemView: View) : ViewHolder(itemView) {
        var taskimg = itemView.findViewById<ImageView>(R.id.img_TaskList)
        var tasktitle = itemView.findViewById<TextView>(R.id.titleName)
        var taskdecription = itemView.findViewById<TextView>(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): taskListHolder {
        val view =
            LayoutInflater.from(mainActivity).inflate(R.layout.tasklist_itemview, parent, false)
        return taskListHolder(view)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: taskListHolder, position: Int) {
        holder.tasktitle.text = taskList[position].title
        holder.taskdecription.text = taskList[position].description
        Glide.with(mainActivity).load(taskList[position].icon).into(holder.taskimg)


    }
}