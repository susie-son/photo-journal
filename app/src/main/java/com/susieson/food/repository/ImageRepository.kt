package com.susieson.food.repository

import android.net.Uri
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

    fun uploadImage(bytes: ByteArray) {
        val imageReference = imagesReference?.child(UUID.randomUUID().toString())
        val uploadTask = imageReference?.putBytes(bytes)
        uploadTask?.addOnSuccessListener {
            val urlTask = imageReference.downloadUrl
            urlTask.addOnSuccessListener {
                imageUrl.value = UploadTaskResult.Success(it)
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
}

sealed class UploadTaskResult {
    data class Success(val uri: Uri) : UploadTaskResult()
    data class Progress(val percentage: Int) : UploadTaskResult()
    data class Error(val exception: Exception) : UploadTaskResult()
}