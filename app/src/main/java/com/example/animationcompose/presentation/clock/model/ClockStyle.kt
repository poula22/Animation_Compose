package com.example.animationcompose.presentation.clock.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ClockStyle(
    val radius: Dp = 150.dp,
    val hoursArrowLength: Dp = 120.dp,
    val minutesArrowLength: Dp = 75.dp,
    val secondsArrowLength: Dp = 25.dp,
    val hoursArrowColor: Color = Color.Black,
    val minutesArrowColor: Color = Color.Black,
    val secondsArrowColor: Color = Color.Red,
    val hoursInitialDegree: Float = 0f,
    val minInitialDegree: Float = 0f,
    val secInitialDegree: Float = 0f,
    val textSize: TextUnit = 24.sp
)
