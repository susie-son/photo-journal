package com.susieson.photo.ui.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.susieson.photo.repository.AuthenticationRepository
import com.susieson.photo.repository.EntryRepository

class HomeViewModel @ViewModelInject constructor(
    authenticationRepository: AuthenticationRepository,
    entryRepository: EntryRepository
) : ViewModel() {
    val user = authenticationRepository.user
    val entries = entryRepository.entries
}