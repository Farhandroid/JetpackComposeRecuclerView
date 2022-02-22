package com.farhan.tanvir.jetpackcomposerv.presentation.screen.home


import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.farhan.tanvir.jetpackcomposerv.data.MovieList

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        backgroundColor = Color.Black,
        contentColor = Color.White,
        content = {
            MovieListContent(allMovies = MovieList.movieList, navController = navController)
        }
    )
}

