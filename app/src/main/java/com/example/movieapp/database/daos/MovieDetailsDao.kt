package com.example.movieapp.database.daos

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MovieDetailsDao {
    @Query("SELECT * FROM movie_details WHERE id = :id")
    fun getById(id: Long)
}