package com.example.animationcompose.circleGame

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.animationcompose.circleGame.component.GameBoard
import com.example.animationcompose.circleGame.component.ScoreBoard

@Composable
fun CircleGameScreen() {
    var score by remember {
        mutableIntStateOf(0)
    }
    var isTimerStart by remember {
        mutableStateOf(false)
    }

    var timer by remember {
        mutableIntStateOf(60)
    }

    Column(Modifier.fillMaxSize()) {

        ScoreBoard(
            score = score,
            isTimerStart = isTimerStart,
            timer = timer,
            toggleTimerState = { isTimerStart = ! isTimerStart },
            resetScore = { score = 0 }
        )
        GameBoard()
    }
}