package com.example.testapp.di

import com.example.testapp.data.service.FilmsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    @Provides
    fun baseUrl(): String = "https://mocky.io/v2/"
    
    private val json = Json {
        isLenient = true
        prettyPrint = true
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
    private val contentType = "application/json; charset=utf-8".toMediaType()
    
    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideRetrofit(BASE_URL: String): Retrofit {
        return Retrofit.Builder().addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(BASE_URL).build()
    }
    
    @Provides
    @Singleton
    fun provideMainService(retrofit: Retrofit): FilmsService =
            retrofit.create(FilmsService::class.java)
    
}