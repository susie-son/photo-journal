package com.susieson.food.ui.main.add

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.susieson.food.model.Entry
import com.susieson.food.repository.EntryRepository

class AddViewModel @ViewModelInject constructor(
    private val entryRepository: EntryRepository
) : ViewModel() {
    lateinit var imageUrl: String
    private val description = MutableLiveData<String>()

    fun setDescription(description: String) {
        this.description.value = description
    }

    fun addEntry() {
        entryRepository.addEntry(
            Entry(
                description = description.value ?: "",
                imageUrl = imageUrl
            )
        )
    }
}