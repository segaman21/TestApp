package com.example.testapp

import android.app.Application
import com.example.testapp.data.repository.FilmsRepository
import com.example.testapp.data.service.FilmsService
import com.example.testapp.ui.main.ViewModelFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

class App : Application() {
    
    companion object {
        private const val baseUrl = "https://mocky.io/v2/"
    }
    
    private val retrofit: Retrofit by lazy {
        val json = Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
        val contentType = "application/json; charset=utf-8".toMediaType()
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(baseUrl)
            .build()
    }
    
    private val filmsService: FilmsService by lazy {
        retrofit.create()
    }
    
    private val filmsRepository: FilmsRepository by lazy {
        FilmsRepository(filmsService = filmsService)
    }
    
    val viewModelFactory: ViewModelFactory by lazy {
        ViewModelFactory(filmsRepository = filmsRepository)
    }
    
}