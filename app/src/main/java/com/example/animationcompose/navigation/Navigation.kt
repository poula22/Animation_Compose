package com.example.animationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animationcompose.circleGame.CircleGameScreen
import com.example.animationcompose.shapes.DrawSomeShapes

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
            DrawSomeShapes(){
                navController.navigate(Screens.CircleGame.route)
            }
        }
        composable(
            route = Screens.CircleGame.route,
        ) {
            CircleGameScreen()
        }
    }
}