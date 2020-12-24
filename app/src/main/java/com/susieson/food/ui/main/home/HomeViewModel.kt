package com.susieson.food.ui.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.susieson.food.repository.AuthenticationRepository

class HomeViewModel @ViewModelInject constructor(
    authenticationRepository: AuthenticationRepository
) : ViewModel() {
    val user = authenticationRepository.user
}