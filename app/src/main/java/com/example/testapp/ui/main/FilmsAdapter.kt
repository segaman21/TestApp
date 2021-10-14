package com.example.testapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.R
import com.example.testapp.data.Films
import com.example.testapp.databinding.FilmItemBinding

typealias OnClick = (Films) -> Unit

class FilmsAdapter(private val filmList:List<Films>, private val onClick: OnClick) : RecyclerView.Adapter<FilmsViewHolder>() {
    
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val binding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmsViewHolder(binding,onClick)
    }
    
    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind(filmList[position])
    }
    
    override fun getItemCount(): Int {
        return filmList.size
    }
}

class FilmsViewHolder(private val binding: FilmItemBinding, onClick: OnClick) :
        RecyclerView.ViewHolder(binding.root) {
    private var currentFilm: Films? = null
    
    init {
        binding.filmItem.apply {
            setOnClickListener {
                currentFilm?.let {
                    onClick(it)
                }
            }
        }
    }
    
    fun bind(item: Films) {
        currentFilm=item
        binding.apply {
            filmName.text = item.name
            filmNameEnglish.text = item.nameEng
            filmImage.let {
                Glide.with(itemView)
                    .load(item.imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(it)
            }
        }
    }
}
