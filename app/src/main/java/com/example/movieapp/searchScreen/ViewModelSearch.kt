package com.example.movieapp.searchScreen

import androidx.lifecycle.ViewModel
import com.example.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelSearch @Inject constructor(
    movieRepository: MovieRepository,

): ViewModel() {
}