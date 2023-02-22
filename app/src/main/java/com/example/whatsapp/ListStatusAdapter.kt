package com.example.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListStatusAdapter(private val listStatus: ArrayList<Chats>) :
    RecyclerView.Adapter<ListStatusAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imhPhoto: ImageView = itemView.findViewById(R.id.imageStatus)
        val tvName: TextView = itemView.findViewById(R.id.tvStatusName)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_status, parent, false)
        return ListStatusAdapter.ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, status, photo) = listStatus[position]
        holder.tvName.text = name
        holder.tvStatus.text = status
        holder.imhPhoto.setImageResource(photo)
    }

    override fun getItemCount(): Int = listStatus.size
}