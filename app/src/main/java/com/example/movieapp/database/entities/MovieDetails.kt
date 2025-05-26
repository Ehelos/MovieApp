package com.example.movieapp.database.entities

import androidx.room.Entity

@Entity("movie_details")
data class MovieDetails(
    val id: Long
) {
}