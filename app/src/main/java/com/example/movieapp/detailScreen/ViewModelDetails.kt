package com.example.movieapp.detailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.MovieRepository
import com.example.movieapp.ui.DestinationDetailsScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelDetails @Inject constructor(
    savedStateHandle: SavedStateHandle,
    movieRepository: MovieRepository
): ViewModel() {
    val id = savedStateHandle.toRoute<DestinationDetailsScreen>().id
}