package com.example.movieapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.detailScreen.ScreenDetail
import com.example.movieapp.searchScreen.ScreenSearch
import kotlinx.serialization.Serializable

@Serializable
object DestinationDetailsScreen

@Serializable
object DestinationSearchScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Any = DestinationSearchScreen
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<DestinationSearchScreen> {
            ScreenSearch()
        }

        composable<DestinationDetailsScreen> { backStackEntry ->
            ScreenDetail()
        }
    }
}