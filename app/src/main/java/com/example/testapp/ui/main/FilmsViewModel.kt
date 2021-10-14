package com.example.testapp.ui.main

import androidx.lifecycle.*
import com.example.testapp.data.Films
import com.example.testapp.data.repository.FilmsRepository

class FilmsViewModel(private val filmsRepository: FilmsRepository) : ViewModel() {
    
    val filmsLiveData: LiveData<List<Films>> = liveData {
        emit(filmsRepository.getFilms())
    }
}

class ViewModelFactory(
        private val filmsRepository: FilmsRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmsViewModel::class.java)) {
            return FilmsViewModel(filmsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
    }
}