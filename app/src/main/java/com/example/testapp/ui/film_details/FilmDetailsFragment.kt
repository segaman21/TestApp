package com.example.testapp.ui.film_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.testapp.data.Films
import com.example.testapp.databinding.FilmDetailsFragmentBinding

class FilmDetailsFragment : Fragment() {
    
    companion object {
        fun newInstance(film: Films): FilmDetailsFragment {
            return FilmDetailsFragment().apply {
                arguments = film.toBundle()
            }
        }
    }
    private val filmDetails by lazy { Films.fromBundle(arguments) }
    
    private var _binding: FilmDetailsFragmentBinding? = null
    private val binding get() = _binding
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FilmDetailsFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            nameText.text= filmDetails?.name
            premiereText.text=filmDetails?.premiere
            descriptionText.text=filmDetails?.description
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun Films.Companion.fromBundle(bundle: Bundle?): Films? {
    val keys = listOf("name", "premiere", "desc")
    return if (bundle != null && keys.all { bundle.containsKey(it) }) {
        Films(
                name = bundle.getString("name"),
                nameEng = null,
                premiere = bundle.getString("premiere"),
                description = bundle.getString("desc"),
                imageUrl = null
        )
    }
    else null
}

private fun Films.toBundle(): Bundle = bundleOf(
        "name" to name,
        "premiere" to premiere,
        "desc" to description,
)