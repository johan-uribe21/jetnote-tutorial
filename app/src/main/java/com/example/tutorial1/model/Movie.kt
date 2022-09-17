package com.example.tutorial1.model

data class Movie(
    val id: String,
    val title: String,
    val genre: String,
    val year: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val images: List<String>,
    val rating: String
)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            "Avatar",
            "Avator: The Movie",
            "SciFi",
            "1999",
            "Kevin Armstrong",
            "Kevin Spacy",
            "Young man doing stuff",
            "https://image.tmdb.org/t/p/original/jRXYjXNq0Cs2TcJjLkki24MLp7u.jpg",
            listOf("https://image.tmdb.org/t/p/original/jRXYjXNq0Cs2TcJjLkki24MLp7u.jpg"),
            "4.2"
        )
    )
}
