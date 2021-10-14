package com.example.testapp.data.service

import com.example.testapp.data.model.ApiData
import retrofit2.http.GET

interface FilmsService {
    @GET("57cffac8260000181e650041")
    suspend fun getFilms(): ApiData
}