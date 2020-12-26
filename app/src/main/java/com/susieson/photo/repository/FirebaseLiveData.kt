package com.susieson.photo.repository

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.*
import timber.log.Timber

class FirebaseUserLiveData : LiveData<FirebaseUser>() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val authStateListener = FirebaseAuth.AuthStateListener { value = it.currentUser }

    override fun onActive() {
        super.onActive()
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    override fun onInactive() {
        super.onInactive()
        firebaseAuth.removeAuthStateListener(authStateListener)
    }
}

class FirestoreCollectionLiveData<T>(
    private val reference: CollectionReference,
    private val valueType: Class<T>,
    private val order: Pair<String, Query.Direction>? = null
) : LiveData<List<T>>() {
    private var listener: ListenerRegistration? = null
    private val eventListener =
        EventListener<QuerySnapshot> { querySnapshot, exception ->
            if (exception != null) {
                Timber.e(exception)
                return@EventListener
            }
            if (querySnapshot != null && !querySnapshot.isEmpty) {
                value = querySnapshot.documents.mapNotNull { it.toObject(valueType) }
            }
        }

    override fun onActive() {
        super.onActive()
        listener = (order?.let { reference.orderBy(it.first, it.second) }
            ?: reference).addSnapshotListener(eventListener)
    }

    override fun onInactive() {
        super.onInactive()
        if (!hasActiveObservers()) {
            listener?.remove()
            listener = null
        }
    }
}