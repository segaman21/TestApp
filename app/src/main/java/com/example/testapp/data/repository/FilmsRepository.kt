package com.example.testapp.data.repository


import com.example.testapp.data.model.Films
import com.example.testapp.data.service.FilmsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmsRepository @Inject constructor(private val mainRemoteData: FilmsService) {
    suspend fun getFilms(): List<Films> {
        return withContext(Dispatchers.IO) {
            mainRemoteData.getFilms().listFilm.map { result ->
                Films(
                        result.image, result.name, result.nameEng, result.premiere, result.description
                )
            }
        }
    }
}


