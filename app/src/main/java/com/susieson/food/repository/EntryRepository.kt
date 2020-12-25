package com.susieson.food.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.susieson.food.model.Entry
import javax.inject.Inject

class EntryRepository @Inject constructor(firestore: FirebaseFirestore) {
    private val collectionReference = FirebaseAuth.getInstance().currentUser?.let {
        firestore.collection("users").document(it.uid).collection("entries")
    }
    val entries = collectionReference?.let { FirestoreCollectionLiveData(it, Entry::class.java) }
}