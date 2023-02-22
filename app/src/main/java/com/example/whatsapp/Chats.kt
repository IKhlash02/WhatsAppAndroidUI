package com.example.whatsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chats(
    val name: String,
    val status: String,
    var photo: Int,
    val arrow: Int,
    val call: Int
): Parcelable
