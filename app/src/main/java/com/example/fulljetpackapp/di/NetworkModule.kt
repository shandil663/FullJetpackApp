package com.example.fulljetpackapp.di

import com.example.fulljetpackapp.TweetAPP
import com.example.fulljetpackapp.api.tweetAPI
import com.example.fulljetpackapp.models.TweetList
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetro(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideApI(retrofit: Retrofit):tweetAPI{
        return retrofit.create(tweetAPI::class.java)
    }
}