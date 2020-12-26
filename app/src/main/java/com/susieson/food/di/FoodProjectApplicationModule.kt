package com.susieson.food.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.susieson.food.repository.AuthenticationRepository
import com.susieson.food.repository.EntryRepository
import com.susieson.food.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object FoodProjectApplicationModule {

    @Singleton
    @Provides
    fun provideAuthenticationRepository() = AuthenticationRepository()

    @Singleton
    @Provides
    fun provideEntryRepository() = EntryRepository(FirebaseFirestore.getInstance())

    @Singleton
    @Provides
    fun provideImageRepository() = ImageRepository(Firebase.storage)

}