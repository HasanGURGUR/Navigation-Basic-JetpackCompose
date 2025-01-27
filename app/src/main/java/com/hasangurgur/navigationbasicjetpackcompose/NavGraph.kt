package com.hasangurgur.navigationbasicjetpackcompose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(name = DETAIL_ARGUMENTS_KEY) {
                    type = NavType.IntType
                },
                navArgument(name = DETAIL_ARGUMENTS_KEY2) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENTS_KEY).toString())
            Log.d("Args", it.arguments?.getString(DETAIL_ARGUMENTS_KEY2).toString())
            DetailScreen(navController = navController)
        }
    }
}