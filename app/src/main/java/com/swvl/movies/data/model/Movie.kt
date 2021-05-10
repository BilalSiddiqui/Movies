package com.swvl.movies.data.model

import java.io.Serializable


data class Movie(
    val cast: List<String>,
    val genres: List<String>,
    val rating: Int,
    val title: String,
    val year: Int
):Serializable