package com.susieson.photo.ui.main.picture

import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import com.susieson.photo.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PictureViewModel @Inject constructor(
    private val imageRepository: ImageRepository
) : ViewModel() {
    val imageUrl = imageRepository.imageUrl

    fun uploadFinished() {
        imageRepository.uploadFinished()
    }

    fun uploadImage(imageProxy: ImageProxy) {
        val planeProxy = imageProxy.planes[0]
        val buffer = planeProxy.buffer
        val bytes = ByteArray(buffer.remaining())
        buffer.get(bytes)
        imageRepository.uploadImage(bytes)
    }
}