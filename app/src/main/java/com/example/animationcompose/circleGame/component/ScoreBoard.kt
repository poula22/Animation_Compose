package com.example.animationcompose.circleGame.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationcompose.ui.theme.AnimationComposeTheme
import kotlinx.coroutines.delay

@Composable
fun ScoreBoard(
    score: Int,
    isTimerStart: Boolean,
    timer: Int = 60,
    toggleTimerState: () -> Unit
) {
    var curTime by remember {
        mutableIntStateOf(timer)
    }
    LaunchedEffect(key1 = curTime,key2 = isTimerStart) {
        if (!isTimerStart) {
            curTime = 60
            return@LaunchedEffect
        }
        if (curTime > 0) {
            delay(1000)
            curTime--;
        } else {
            toggleTimerState()
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "score: $score")
        Button(onClick = {
            toggleTimerState()
        }) {
            Text(text = if (!isTimerStart) "start" else "reset")
        }
        Text(text = "time: $curTime")
    }
}

@Preview
@Composable
private fun PreviewBoard() {
    AnimationComposeTheme {
        ScoreBoard(0, false, 60,toggleTimerState = {  })
    }
}