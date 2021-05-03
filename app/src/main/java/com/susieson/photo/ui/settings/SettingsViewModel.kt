package com.susieson.photo.ui.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.susieson.photo.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
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