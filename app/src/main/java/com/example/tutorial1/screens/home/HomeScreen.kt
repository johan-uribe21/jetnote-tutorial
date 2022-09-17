package com.example.tutorial1.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorial1.model.Movie
import com.example.tutorial1.model.getMovies
import com.example.tutorial1.navigation.MovieScreens
import com.example.tutorial1.widgets.MovieRow
import com.example.tutorial1.widgets.RoundIconButton

//@Preview
//@Composable
//fun PreviewHomeScreen() {
//    HomeScreen(navController = )
//}

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.DarkGray,
                elevation = 5.dp,
            ) {
                Text(text = "Movies")
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp,
            ) {
                RoundIconButton(
                    imageVector = Icons.Default.VideoLibrary,
                    onClick = { }
                )
                RoundIconButton(
                    imageVector = Icons.Default.List,
                    onClick = { }
                )
            }
        }
    ) {
        MyMainContent(navController = navController)
    }
}

@Composable
fun MyMainContent(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        val movieList: List<Movie> = getMovies()
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn {
                items(items = movieList) {
                    MovieRow(movie = it) { movieTitle ->
                        navController.navigate(route = MovieScreens.DetailScreen.name + "/$movieTitle")
                    }
                }
            }
        }
    }
}
