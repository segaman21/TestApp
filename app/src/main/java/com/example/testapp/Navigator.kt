package com.example.testapp

import com.example.testapp.data.Films

interface Navigator {
    fun navigateToDetailsFragment(film:Films)
}