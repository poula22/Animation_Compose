package com.example.animationcompose.navigation

sealed class Screens(val route: String) {
    data object Shapes: Screens("shapes")
    data object CircleGame: Screens("circleGame")
}