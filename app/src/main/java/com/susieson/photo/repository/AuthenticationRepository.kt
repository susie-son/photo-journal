package com.susieson.photo.repository

import android.content.Context
import com.firebase.ui.auth.AuthUI
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(private val auth: AuthUI) {
    val user = FirebaseUserLiveData()

    fun signOut(context: Context) {
        auth.signOut(context)
    }

    fun deleteAccount(context: Context) {
        auth.delete(context)
    }
}