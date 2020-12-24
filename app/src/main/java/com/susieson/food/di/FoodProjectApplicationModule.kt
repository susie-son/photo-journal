package com.susieson.food.di

import com.susieson.food.repository.AuthenticationRepository
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

}