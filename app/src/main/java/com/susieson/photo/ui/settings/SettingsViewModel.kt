package com.susieson.photo.ui.settings

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.susieson.photo.repository.AuthenticationRepository

class SettingsViewModel @ViewModelInject constructor(
    private val app: Application,
    private val authenticationRepository: AuthenticationRepository
) : AndroidViewModel(app) {
    fun signOut() {
        authenticationRepository.signOut(app)
    }

    fun deleteAccount() {
        authenticationRepository.deleteAccount(app)
    }
}