package com.example.testapp

import com.example.testapp.data.model.Films

interface Navigator {
    fun navigateToDetailsFragment(film: Films)
}