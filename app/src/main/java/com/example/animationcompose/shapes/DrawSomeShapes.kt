package com.example.animationcompose.shapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationcompose.ui.theme.AnimationComposeTheme

@Composable
fun DrawSomeShapes() {
    Canvas(modifier = Modifier.size(500.dp)) {
        drawRoundRect(
            color = Color.White,
            style = Stroke(width = 16.dp.toPx()),
            topLeft = Offset(8.dp.toPx(),8.dp.toPx()),
            size = Size(216.dp.toPx(),216.dp.toPx()),
        )
        drawRoundRect(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color.Red,
                    Color.Yellow
                ),
                startX = 26.dp.toPx(),
                endX = 216.dp.toPx()
            ),
            topLeft = Offset(16.dp.toPx(),16.dp.toPx()),
            size = Size(200.dp.toPx(),200.dp.toPx())
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.Magenta,
                    Color.Cyan
                ),
                radius = 65.dp.toPx(),
                center = Offset(116.dp.toPx(),116.dp.toPx())
            ),
            radius = 55.dp.toPx(),
            center = Offset(116.dp.toPx(),116.dp.toPx())
        )

    }
}


@Preview
@Composable
private fun PreviewDraw() {
    AnimationComposeTheme {
        DrawSomeShapes()
    }
}