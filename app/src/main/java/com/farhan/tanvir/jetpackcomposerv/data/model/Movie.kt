package com.farhan.tanvir.jetpackcomposerv.data.model
import java.io.Serializable

data class Movie(
    val movieId: Int,
    val overview: String,
    val imageId: Int,
    val title: String,
    val rating: String,
    val releaseDate: String,
):Serializable
