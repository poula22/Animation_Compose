package com.example.animationcompose.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animationcompose.presentation.circleGame.CircleGameScreen
import com.example.animationcompose.presentation.shapes.DrawSomeShapes
import com.example.animationcompose.presentation.weightSelector.WeightSelectorScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val  navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Shapes.route
    ) {
        composable(
            route = Screens.Shapes.route
        ) {
            DrawSomeShapes { route ->
                navController.navigate(route)
            }
        }
        composable(
            route = Screens.CircleGame.route,
        ) {
            CircleGameScreen()
        }
        composable(
            route = Screens.WeightSelector.route
        ) {
            WeightSelectorScreen()
        }
    }
}