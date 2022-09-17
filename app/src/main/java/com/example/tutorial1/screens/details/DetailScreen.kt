package com.example.tutorial1.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, movieData: String?) {
    DetailsScreenScaffold(navController = navController) {
        DetailsScreenContent(movieData = movieData, navController = navController)
    }
}

@Composable
fun DetailsScreenScaffold(navController: NavController, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.DarkGray,
                elevation = 5.dp,
            ) {
                Row() {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                }
            }
        },
    ) {
        content()
    }
}

@Composable
fun DetailsScreenContent(movieData: String?, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = movieData.toString(),
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(23.dp))
        }
    }
}