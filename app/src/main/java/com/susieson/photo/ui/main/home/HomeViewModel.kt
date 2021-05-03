package com.susieson.photo.ui.main.home

import androidx.lifecycle.ViewModel
import com.susieson.photo.repository.AuthenticationRepository
import com.susieson.photo.repository.EntryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    authenticationRepository: AuthenticationRepository,
    entryRepository: EntryRepository
) : ViewModel() {
    val user = authenticationRepository.user
    val entries = entryRepository.entries
}