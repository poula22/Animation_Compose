package com.example.animationcompose.presentation.circleGame

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.animationcompose.presentation.circleGame.component.GameBoard
import com.example.animationcompose.presentation.circleGame.component.ScoreBoard

@Composable
fun CircleGameScreen() {
    var score by remember {
        mutableIntStateOf(0)
    }
    var isTimerStart by remember {
        mutableStateOf(false)
    }

    Column(Modifier.fillMaxSize()) {

        ScoreBoard(
            score = score,
            isTimerStart = isTimerStart,
            toggleTimerState = {
                if (isTimerStart){
                    score = 0
                }
                isTimerStart = !isTimerStart
            },
        )

        GameBoard(
            enabled = isTimerStart,
            onBallClick = {
                score++
            }
        )
    }
}