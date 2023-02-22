package com.example.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCallAdapter(private val listCall: ArrayList<Chats>) :
    RecyclerView.Adapter<ListCallAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.imagecall)
        var tvChats: TextView = itemView.findViewById(R.id.tvCallDate)
        val tvName: TextView = itemView.findViewById(R.id.tvCallName)
        var imgArrow: ImageView = itemView.findViewById(R.id.arrowCalls)
        var imgCall: ImageView = itemView.findViewById(R.id.typeCall)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_calls, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, status, photo, arrow, call) = listCall[position]
        holder.tvName.text = name
        holder.tvChats.text = status
        holder.imgPhoto.setImageResource(photo)
        holder.imgArrow.setImageResource(arrow)
        holder.imgCall.setImageResource(call)
    }

    override fun getItemCount(): Int = listCall.size
}