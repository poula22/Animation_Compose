package com.example.animationcompose.presentation.shapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationcompose.core.navRoutes.Screens
import com.example.animationcompose.core.ui.theme.AnimationComposeTheme

@Composable
fun DrawSomeShapes(onNavigate: (String) -> Unit) {
    val borderColor = MaterialTheme.colorScheme.onSurface

    Box(modifier = Modifier.fillMaxSize() ){
        Canvas(modifier = Modifier.fillMaxSize()) {
            inset(horizontal = center.x - 108.dp.toPx(), center.y/1.4f - 108.dp.toPx()) {
                drawRoundRect(
                    color = borderColor,
                    size = Size(216.dp.toPx(), 216.dp.toPx()),
                    topLeft = Offset(0f, 0f),
                    cornerRadius = CornerRadius(8.dp.toPx(),8.dp.toPx()),
                    style = Stroke(width = 16.dp.toPx()),
                )
                drawRoundRect(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Yellow
                        ),
                        startX = 18.dp.toPx(),
                        endX = 208.dp.toPx()
                    ),
                    topLeft = Offset(8.dp.toPx(),  8.dp.toPx()),
                    size = Size(200.dp.toPx(), 200.dp.toPx())
                )
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color.Magenta,
                            Color.Cyan
                        ),
                        radius = 65.dp.toPx(),
                        center = Offset( 108.dp.toPx(), 108.dp.toPx())
                    ),
                    radius = 55.dp.toPx(),
                    center = Offset(108.dp.toPx(), 108.dp.toPx())
                )
            }

        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 200.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    onNavigate(Screens.CircleGame.route)
                }
            ) {
                Text(text = "Circle Game", fontSize = 24.sp)
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    onNavigate(Screens.WeightSelector.route)
                }
            ) {
                Text(text = "Weight Selector", fontSize = 24.sp)
            }
        }
    }

}


@Preview
@Composable
private fun PreviewDraw() {
    AnimationComposeTheme {
        DrawSomeShapes(){}
    }
}