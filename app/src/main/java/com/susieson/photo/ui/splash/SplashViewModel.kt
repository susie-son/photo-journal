package com.susieson.photo.ui.splash

import androidx.lifecycle.ViewModel
import com.susieson.photo.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    authenticationRepository: AuthenticationRepository
) : ViewModel() {
    val user = authenticationRepository.user
}