package com.example.movieapp.database

import android.content.Context
import androidx.room.Room
import com.example.movieapp.database.daos.MovieDetailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MovieDatabase {
        return Room.databaseBuilder(
            appContext,
            MovieDatabase::class.java,
            "my_database"
        ).build()
    }
    @Provides
    fun provideMovieDao(db: MovieDatabase): MovieDetailsDao {
        return db.movieDao()
    }
}
