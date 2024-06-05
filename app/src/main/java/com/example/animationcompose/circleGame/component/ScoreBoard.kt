package com.example.animationcompose.circleGame.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationcompose.ui.theme.AnimationComposeTheme

@Composable
fun ScoreBoard(
    score: Int,
    isTimerStart: Boolean,
    timer: Int,
    toggleTimerState: () -> Unit,
    resetScore: () -> Unit
) {

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
            resetScore()
        }) {
            Text(text = if (!isTimerStart) "start" else "reset")
        }
        Text(text = "time: $timer")
    }
}

@Preview
@Composable
private fun PreviewBoard() {
    AnimationComposeTheme {
        ScoreBoard(0, false, 60,toggleTimerState = {  }, resetScore = { })
    }
}