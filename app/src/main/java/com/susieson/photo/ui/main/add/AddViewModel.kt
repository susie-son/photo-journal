package com.susieson.photo.ui.main.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.susieson.photo.model.Entry
import com.susieson.photo.repository.EntryRepository
import com.susieson.photo.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val entryRepository: EntryRepository,
    private val imageRepository: ImageRepository
) : ViewModel() {
    lateinit var imageUrl: String
    lateinit var imageId: String
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

    fun deleteImage() {
        imageRepository.deleteImage(imageId)
    }
}