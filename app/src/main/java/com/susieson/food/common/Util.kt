package com.susieson.food.common

import java.text.DateFormat
import java.util.*

fun formatDate(date: Date): String {
    val formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT)
    return formatter.format(date)
}