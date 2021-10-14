package com.example.testapp.data


data class Films (
     val imageUrl: String?,
     val name: String?,
     val nameEng: String?,
     val premiere: String?,
     val description: String?,
){
    companion object {
        const val name = "name"
        const val premiere = "premiere"
        const val description = "desc"
    }
}