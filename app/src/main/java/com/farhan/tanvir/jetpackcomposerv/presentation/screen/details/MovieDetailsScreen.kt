package com.farhan.tanvir.jetpackcomposerv.presentation.screen.details
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.farhan.tanvir.jetpackcomposerv.data.MovieList


@Composable
fun MovieDetailsScreen(
    movieId: String,
) {
    val movie = MovieList.movieList.first { it.movieId == movieId.toInt() }
    Scaffold(
        contentColor = Color.White,
        backgroundColor = Color.DarkGray,
        content = {
             MovieDetailsContent(movie = movie)
        })
}

