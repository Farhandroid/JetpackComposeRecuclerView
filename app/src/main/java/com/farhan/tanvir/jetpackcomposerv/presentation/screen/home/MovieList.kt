package com.farhan.tanvir.jetpackcomposerv.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.farhan.tanvir.jetpackcomposerv.data.model.Movie
import com.farhan.tanvir.jetpackcomposerv.navigation.Screen
import com.farhan.tanvir.jetpackcomposerv.presentation.components.RatingComponent

@Composable
fun MovieListContent(allMovies: List<Movie>, navController: NavHostController) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(
            items = allMovies,
            itemContent = {
                MovieListItem(movie = it, navController = navController)
            }
        )
    }
}

@Composable
fun MovieListItem(movie: Movie, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .height(180.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = Color.DarkGray
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth()
                .clickable {
                    navController.navigate(route = Screen.MovieDetails.passMovieId(movie.movieId.toString()))
                },
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .padding(
                        end = 4.dp,
                    )
                    .width(120.dp),
                painter = painterResource(id = movie.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(Modifier
                .height(IntrinsicSize.Max)
                .padding(
                    end = 2.dp,
                )) {
                Text(text = movie.title, style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.body2,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))
                RatingComponent(rating = movie.rating)
            }
        }
    }
}
