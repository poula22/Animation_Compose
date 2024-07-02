package com.example.animationcompose.presentation.weightSelector.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import android.graphics.Paint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.withRotation
import com.example.animationcompose.presentation.weightSelector.component.utils.drawWeightCircle
import com.example.animationcompose.presentation.weightSelector.component.utils.drawWeightLine
import com.example.animationcompose.presentation.weightSelector.component.utils.drawWeightText
import com.example.animationcompose.presentation.weightSelector.model.LineType
import com.example.animationcompose.presentation.weightSelector.model.ScaleStyle
import com.example.animationcompose.core.ui.theme.AnimationComposeTheme
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeightElement(
    modifier: Modifier = Modifier,
    scaleStyle: ScaleStyle = ScaleStyle(),
    minWeight: Int = 20,
    maxWeight: Int = 250,
    initialWeight: Int = 80,
    onWeightChange: (Int) -> Unit
) {
    val radius = scaleStyle.radius
    val scaleWidth = scaleStyle.scaleWidth
    var center by remember {
        mutableStateOf(Offset.Zero)
    }
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var angle by remember {
        mutableFloatStateOf(0f)
    }
    var oldAngle by remember {
        mutableFloatStateOf(angle)
    }
    var dragStartAngle by remember {
        mutableFloatStateOf(0f)
    }

    Canvas(
        modifier = modifier
            .pointerInput(true) {
                detectDragGestures(
                    onDragStart = { offset ->
                        dragStartAngle = - atan2(
                            y = circleCenter.x - offset.x,
                            x = circleCenter.y - offset.y
                        ) * (180f / PI.toFloat())

                    },
                    onDragEnd = {
                        oldAngle = angle
                    }
                ) { change, _ ->
                    val position = change.position
                    val touchAngle = - atan2(
                        y = circleCenter.x - position.x,
                        x = circleCenter.y - position.y
                    ) * (180f / PI.toFloat())
                    val newAngle = oldAngle + (touchAngle - dragStartAngle)
                    angle = newAngle.coerceIn(
                        minimumValue = initialWeight - maxWeight.toFloat(),
                        maximumValue = initialWeight - minWeight.toFloat()
                    )
                    onWeightChange((initialWeight - angle).roundToInt())
                }
            }
    ) {
        center = this.center
        circleCenter = Offset(
            x = center.x,
            y = radius.toPx() + scaleWidth.toPx() / 2f
        )
        val outerRadius = radius.toPx() + scaleWidth.toPx() / 2f
        val innerRadius = radius.toPx() - scaleWidth.toPx() / 2f
        drawContext.canvas.nativeCanvas.apply {
            drawWeightCircle(
                circleCenter = circleCenter,
                radius = radius.toPx(),
                strokeWidth = scaleWidth.toPx()
            )
        }
        for (i in minWeight..maxWeight) {
            val lineType = when {
                i % 10 == 0 -> LineType.TenStep
                i % 5 == 0 -> LineType.FiveStep
                else -> LineType.Normal
            }
            val angleInRad = (i - initialWeight + angle - 90) * (PI / 180f).toFloat()

            drawWeightLine(
                lineType = lineType,
                scaleStyle = scaleStyle,
                angleInRad = angleInRad,
                outerRadius = outerRadius,
                circleCenter = circleCenter
            )
            if (lineType is LineType.TenStep) {
                val textRadius =
                    outerRadius - scaleStyle.tenStepLineLength.toPx() - 5.dp.toPx() - 24.sp.toPx()
                val x = textRadius * cos(angleInRad) + circleCenter.x
                val y = textRadius * sin(angleInRad) + circleCenter.y
                drawContext.canvas.nativeCanvas.apply {
                    withRotation(
                        degrees = angleInRad * (180f / PI.toFloat()) + 90f,
                        pivotX = x,
                        pivotY = y
                    ) {
                        drawWeightText(
                            text = abs(i).toString(),
                            textSize = 24.sp.toPx(),
                            x = x,
                            y = y
                        )
                    }
                }
            }

        }
        val middleTop = Offset(
            x = circleCenter.x,
            y = circleCenter.y - innerRadius - scaleStyle.scaleIndicatorLength.toPx()
        )
        val bottomLeft = Offset(
            x = circleCenter.x - 4f,
            y = circleCenter.y - innerRadius
        )
        val bottomRight = Offset(
            x = circleCenter.x + 4f,
            y = circleCenter.y - innerRadius
        )
        val path = Path().apply {
            moveTo(middleTop.x, middleTop.y)
            lineTo(bottomLeft.x, bottomLeft.y)
            lineTo(bottomRight.x, bottomRight.y)
        }
        drawPath(path = path, color = scaleStyle.scaleIndicatorColor)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun PreviewWeightElement() {
    AnimationComposeTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            WeightElement(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
            ) {}
        }

    }
}