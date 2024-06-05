package com.example.animationcompose.circleGame.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationcompose.ui.theme.AnimationComposeTheme
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun GameBoard() {
    val radius by remember {
        mutableStateOf(30.dp)
    }
    BoxWithConstraints {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color.Red,
                radius = radius.toPx(),
                center = Offset(
                    x = Random.nextInt(
                        constraints.minWidth + radius.toPx().roundToInt(),
                        constraints.maxWidth - radius.toPx().roundToInt()
                    ).toFloat(),
                    y = Random.nextInt(
                        constraints.minHeight + radius.toPx().roundToInt(),
                        constraints.maxHeight - radius.toPx().roundToInt()
                    ).toFloat()
                )
            )
        }
    }
}

@Preview
@Composable
private fun PreviewGameBoard() {
    AnimationComposeTheme {
        GameBoard()
    }
}