package com.example.movielist.data.dataClasses

data class Movie(
    val name: String,
    val description: String?,
    val actors: List<String>? = emptyList(),
    val budget: Int? = null
)
