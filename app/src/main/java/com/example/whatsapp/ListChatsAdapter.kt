package com.example.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListChatsAdapter(private val listChats: ArrayList<Chats>) :
    RecyclerView.Adapter<ListChatsAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imhPhoto: ImageView = itemView.findViewById(R.id.imageChats)
        var tvChats: TextView = itemView.findViewById(R.id.tvChatsDeskripsi)
        val tvName: TextView = itemView.findViewById(R.id.tvChats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_chats, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, status, photo) = listChats[position]
        holder.tvName.text = name
        holder.tvChats.text = status
        holder.imhPhoto.setImageResource(photo)
    }

    override fun getItemCount(): Int = listChats.size

}