package com.susieson.photo.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import java.util.*
import javax.inject.Inject
import kotlin.math.roundToInt

class ImageRepository @Inject constructor(storage: FirebaseStorage) {
    private val imagesReference = FirebaseAuth.getInstance().currentUser?.let {
        storage.reference.child(it.uid)
    }
    var imageUrl = MutableLiveData<UploadTaskResult>()

    fun uploadFinished() {
        imageUrl.value = null
    }

    fun uploadImage(bytes: ByteArray) {
        val id = UUID.randomUUID().toString()
        val imageReference = imagesReference?.child(id)
        val uploadTask = imageReference?.putBytes(bytes)
        uploadTask?.addOnSuccessListener {
            val urlTask = imageReference.downloadUrl
            urlTask.addOnSuccessListener {
                imageUrl.value = UploadTaskResult.Success(it.toString(), id)
            }
            urlTask.addOnFailureListener {
                imageUrl.value = UploadTaskResult.Error(it)
            }
        }
        uploadTask?.addOnProgressListener {
            imageUrl.value =
                UploadTaskResult.Progress((it.bytesTransferred / it.totalByteCount * 100.0).roundToInt())
        }
        uploadTask?.addOnFailureListener {
            imageUrl.value = UploadTaskResult.Error(it)
        }
    }

    fun deleteImage(file: String) {
        val imageReference = imagesReference?.child(file)
        imageReference?.delete()
    }
}

sealed class UploadTaskResult {
    data class Success(val uri: String, val id: String) : UploadTaskResult()
    data class Progress(val percentage: Int) : UploadTaskResult()
    data class Error(val exception: Exception) : UploadTaskResult()
}