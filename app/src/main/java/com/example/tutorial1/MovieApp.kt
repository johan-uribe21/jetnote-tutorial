package com.example.tutorial1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorial1.navigation.MovieNavigation
import com.example.tutorial1.ui.theme.Tutorial1Theme
import com.example.tutorial1.widgets.RoundIconButton

@Preview
@Composable
fun MovieAppPreview() {
    MovieApp {
        MovieNavigation()
    }
}

@Composable
fun MovieApp(content: @Composable () -> Unit) {
    Tutorial1Theme {
        content()
    }
}
