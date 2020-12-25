package com.susieson.food.ui.main.add

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.susieson.food.model.Entry
import com.susieson.food.repository.EntryRepository

class AddViewModel @ViewModelInject constructor(
    private val entryRepository: EntryRepository
) : ViewModel() {
    private val name = MutableLiveData<String>()
    val isNameValid = MutableLiveData<Boolean>()

    fun setName(name: String) {
        this.name.value = name
        isNameValid.value = name.isNotBlank()
    }

    val areEntriesValid = MediatorLiveData<Boolean>().apply {
        addSource(isNameValid) {
            value = areEntriesValid()
        }
    }

    private fun areEntriesValid(): Boolean {
        return isNameValid.value ?: false
    }

    fun addEntry() {
        entryRepository.addEntry(
            Entry(
                name = name.value ?: ""
            )
        )
    }
}