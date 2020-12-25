package com.susieson.food.ui.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.susieson.food.repository.AuthenticationRepository
import com.susieson.food.repository.EntryRepository

class HomeViewModel @ViewModelInject constructor(
    authenticationRepository: AuthenticationRepository,
    entryRepository: EntryRepository
) : ViewModel() {
    val user = authenticationRepository.user
    val entries = entryRepository.entries
}