package com.susieson.photo.model

import com.google.firebase.Timestamp

data class Entry(
    val description: String = "",
    val imageUrl: String = "",
    val timestamp: Timestamp = Timestamp.now()
)