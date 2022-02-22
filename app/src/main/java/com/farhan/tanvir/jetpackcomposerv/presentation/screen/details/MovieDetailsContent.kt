package com.farhan.tanvir.jetpackcomposerv.presentation.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farhan.tanvir.jetpackcomposerv.data.model.Movie
import com.farhan.tanvir.jetpackcomposerv.presentation.components.RatingComponent
import com.farhan.tanvir.jetpackcomposerv.presentation.components.ReleaseDateComponent

@Composable
fun MovieDetailsContent(movie: Movie) {
    val scrollState = rememberScrollState()
    Card(
        elevation = 0.dp,
        backgroundColor = Color.DarkGray
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(id = movie.imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                ReleaseDateComponent(releaseDate = movie.releaseDate)
                Spacer(modifier = Modifier.height(8.dp))
                RatingComponent(rating = movie.rating)
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.body2
                )

            }
        }
    }
}