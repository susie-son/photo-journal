package com.susieson.food.di

import com.google.firebase.firestore.FirebaseFirestore
import com.susieson.food.repository.AuthenticationRepository
import com.susieson.food.repository.EntryRepository
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

}