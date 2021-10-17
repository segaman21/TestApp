package com.example.testapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ApiData(
        @SerialName("list") val listFilm: List<ResultFilms>)


@Serializable
data class ResultFilms(
        @SerialName("image") val image: String,
        @SerialName("name") val name: String,
        @SerialName("name_eng") val nameEng: String,
        @SerialName("premiere") val premiere: String,
        @SerialName("description") val description: String
)


