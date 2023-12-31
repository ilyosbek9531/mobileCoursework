package com.example.movielist.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movielist.addNew.AddNewActivity
import com.example.movielist.list.MoviesList
import com.example.movielist.profile.PlayerScreen

@Composable
fun Navigation(navController: NavHostController, context: Context) {
    NavHost(navController = navController, startDestination = Screens.MoviesListScreen.route) {
        composable(Screens.MoviesListScreen.route) {
            MoviesList(onAddNewMovieClick = {
                context.startActivity(Intent(context, AddNewActivity::class.java))
            }, onPlayerBtnClick = {
                navController.navigate(Screens.PlayerPageScreen.route)
            })
        }

        composable(Screens.PlayerPageScreen.route) {
            PlayerScreen()
        }
    }
}