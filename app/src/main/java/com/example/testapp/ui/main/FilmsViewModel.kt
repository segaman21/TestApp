package com.example.testapp.ui.main

import androidx.lifecycle.*
import com.example.testapp.data.model.Films
import com.example.testapp.data.repository.FilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(private val filmsRepository: FilmsRepository) : ViewModel() {
    
    val filmsLiveData: LiveData<List<Films>> = liveData {
        emit(filmsRepository.getFilms())
    }
}
