package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.testapp.data.Films
import com.example.testapp.ui.film_details.FilmDetailsFragment
import com.example.testapp.ui.main.MainFragment

class MainActivity : AppCompatActivity(),Navigator {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commit()
        }
    }
    
    override fun navigateToDetailsFragment(film: Films) {
        supportFragmentManager.commit {
            replace(R.id.container, FilmDetailsFragment.newInstance(film))
            addToBackStack(null)
        }
    }
    
}