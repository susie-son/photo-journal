package com.susieson.food.repository

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepository {
    val user = FirebaseUserLiveData()
}

class FirebaseUserLiveData : LiveData<FirebaseUser>() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val authStateListener = AuthStateListener { value = it.currentUser }

    override fun onActive() {
        super.onActive()
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    override fun onInactive() {
        super.onInactive()
        firebaseAuth.removeAuthStateListener(authStateListener)
    }
}