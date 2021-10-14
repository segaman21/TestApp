package com.example.testapp.data.repository

import com.example.testapp.data.Films
import com.example.testapp.data.service.FilmsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmsRepository(private val filmsService: FilmsService) {
    suspend fun getFilms(): List<Films> {
        return withContext(Dispatchers.IO) {
            filmsService.getFilms().listFilm.map { result ->
                Films(
                        result.image,
                        result.name,
                        result.nameEng,
                        result.premiere,
                        result.description
                )
            }
        }
    }
}


