package com.susieson.photo.ui.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.susieson.photo.repository.AuthenticationRepository

class SplashViewModel @ViewModelInject constructor(
    authenticationRepository: AuthenticationRepository
) : ViewModel() {
    val user = authenticationRepository.user
}