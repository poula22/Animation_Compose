package com.example.animationcompose.core.navRoutes

sealed class Screens(val route: String) {
    data object Shapes: Screens("shapes")
    data object CircleGame: Screens("circleGame")
    data object WeightSelector: Screens("weightSelector")
}