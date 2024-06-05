package com.example.animationcompose.shapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.MultiParagraph
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationcompose.ui.theme.AnimationComposeTheme

@Composable
fun DrawSomeShapes(onNavigate: () -> Unit) {
    val borderColor = MaterialTheme.colorScheme.onSurface

    Box(modifier = Modifier.fillMaxSize() ){
        Canvas(modifier = Modifier.fillMaxSize()) {
            inset(horizontal = center.x - 108.dp.toPx(), center.y/1.5f - 108.dp.toPx()) {
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
        Button(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 154.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            ,
            onClick = onNavigate
        ) {
            Text(text = "Start Game", fontSize = 24.sp)
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