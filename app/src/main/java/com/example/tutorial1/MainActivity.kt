package com.example.tutorial1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tutorial1.navigation.MovieNavigation
import com.example.tutorial1.ui.theme.Tutorial1Theme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    private fun logging() {
        Log.v(TAG, "Hello, world!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp {
                MovieNavigation()
            }
        }
        logging()
    }
}
