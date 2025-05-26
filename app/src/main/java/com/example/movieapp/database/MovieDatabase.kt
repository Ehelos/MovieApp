package com.example.movieapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.database.daos.MovieDetailsDao
import com.example.movieapp.database.entities.MovieDetails

@Database(entities = [MovieDetails::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDetailsDao
}
