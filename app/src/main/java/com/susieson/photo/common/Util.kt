package com.susieson.photo.common

import android.content.Context
import android.content.DialogInterface
import androidx.annotation.StringRes
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.DateFormat
import java.util.*

fun formatDate(date: Date): String {
    val formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT)
    return formatter.format(date)
}

fun showAlertDialog(
    context: Context,
    @StringRes title: Int,
    @StringRes message: Int,
    @StringRes positive: Int = android.R.string.ok,
    @StringRes negative: Int = android.R.string.cancel,
    positiveListener: DialogInterface.OnClickListener? = null,
    negativeListener: DialogInterface.OnClickListener? = null
) {
    MaterialAlertDialogBuilder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(positive, positiveListener)
        .setNegativeButton(negative, negativeListener)
        .show()
}