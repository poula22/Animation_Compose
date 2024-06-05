package com.example.animationcompose.circleGame.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animationcompose.ui.theme.AnimationComposeTheme
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.random.Random

@Composable
fun GameBoard(
    radius: Float = 100F,
    enabled: Boolean = false,
    ballColor: Color = Color.Red,
    onBallClick: () -> Unit
) {

    BoxWithConstraints {

        var ballPosition by remember {
            mutableStateOf(
                randomOffset(
                    radius = radius,
                    width = constraints.maxWidth,
                    height = constraints.maxHeight
                )
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(enabled) {
                    if (!enabled) {
                        return@pointerInput
                    }
                    detectTapGestures {
                        val distance = sqrt(
                            (it.x - ballPosition.x).pow(2) + (it.y - ballPosition.y).pow(2)
                        )
                        if (distance <= radius) {
                            ballPosition = randomOffset(
                                    radius = radius,
                                    width = constraints.maxWidth,
                                    height = constraints.maxHeight
                                )
                            onBallClick()
                        }
                    }
                }
        ) {
            drawCircle(
                color = ballColor,
                radius = radius,
                center = ballPosition
            )
        }
    }
}

fun randomOffset(radius: Float, width: Int, height: Int): Offset {
    return Offset(
        x = Random.nextInt(
            radius.roundToInt(),
            width - radius.roundToInt()
        ).toFloat(),
        y = Random.nextInt(
            radius.roundToInt(),
            height - radius.roundToInt()
        ).toFloat()
    )
}

@Preview
@Composable
private fun PreviewGameBoard() {
    AnimationComposeTheme {
        GameBoard(enabled = true, onBallClick = {})
    }
}