package com.susieson.photo.di

import com.firebase.ui.auth.AuthUI
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.susieson.photo.repository.AuthenticationRepository
import com.susieson.photo.repository.EntryRepository
import com.susieson.photo.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PhotoProjectApplicationModule {

    @Singleton
    @Provides
    fun provideAuthenticationRepository() = AuthenticationRepository(AuthUI.getInstance())

    @Singleton
    @Provides
    fun provideEntryRepository() = EntryRepository(FirebaseFirestore.getInstance())

    @Singleton
    @Provides
    fun provideImageRepository() = ImageRepository(Firebase.storage)

}