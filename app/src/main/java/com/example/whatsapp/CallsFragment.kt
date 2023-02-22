package com.example.whatsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CallsFragment : Fragment() {

    private lateinit var rvChats: RecyclerView
    private val list = ArrayList<Chats>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvChats = view.findViewById(R.id.rvCall)
        rvChats.setHasFixedSize(true)

        list.addAll(getListChats())
        showRecycle()
    }

    @SuppressLint("Recycle")
    private fun getListChats(): ArrayList<Chats> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataStatus = resources.getStringArray(R.array.data_date_call)
        val dataArrow = resources.obtainTypedArray(R.array.data_arrow)
        val dataCall = resources.obtainTypedArray(R.array.data_call)
        val listCall = ArrayList<Chats>()
        for (i in dataName.indices) {
            val chats = Chats(
                dataName[i], dataStatus[i], dataPhoto.getResourceId(i, -1),
                dataArrow.getResourceId(i, -1), dataCall.getResourceId(i, -1)
            )
            listCall.add(chats)
        }
        return listCall
    }

    private fun showRecycle() {
        rvChats.layoutManager = LinearLayoutManager(activity)
        val listCallsAdapter = ListCallAdapter(list)
        rvChats.adapter = listCallsAdapter
    }

}