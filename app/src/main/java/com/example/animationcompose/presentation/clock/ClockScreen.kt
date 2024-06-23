package com.example.animationcompose.presentation.clock

import android.graphics.Paint
import android.icu.util.Calendar
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withRotation
import com.example.animationcompose.presentation.clock.model.ClockStyle
import com.example.animationcompose.ui.theme.AnimationComposeTheme
import java.util.Date
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ClockScreen(
    modifier: Modifier = Modifier,
    curTime: Date = Calendar.getInstance().time,
    clockStyle: ClockStyle
) {

    val rect = android.graphics.Rect()

    val hoursDegree by remember {
        mutableFloatStateOf(0f)
    }
    val minDegree by remember {
        mutableFloatStateOf(10f)
    }
    val secDegree by remember {
        mutableFloatStateOf(20f)
    }


    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = modifier.fillMaxWidth()) {
            drawContext.canvas.nativeCanvas.apply {
                val curHoursDegree = hoursDegree - clockStyle.hoursInitialDegree
                val hx = clockStyle.radius.toPx() + center.x - 16.dp.toPx()
                val mx = clockStyle.radius.toPx() + center.x - 24.dp.toPx()
                val sx = clockStyle.radius.toPx() + center.x

                val topPoint = Offset(
                    x = center.x,
                    y = center.y + 4.dp.toPx()
                )
                val bottomPoint = Offset(
                    x = center.x,
                    y = center.y - 4.dp.toPx()
                )
                drawCircle(
                    center.x,
                    center.y,
                    clockStyle.radius.toPx(),
                    Paint().apply {
                        color = android.graphics.Color.WHITE
                        setShadowLayer(
                            60f,
                            0f,
                            0f,
                            android.graphics.Color.argb(
                                0.5f,
                                0f,
                                0f,
                                0f
                            )
                        )
                    }
                )
                Log.i("angle", curTime.toString())
                for (i in 0..59) {
                    val angleInRad = (i * 6) * (PI / 180f)
                    Log.i("angle", angleInRad.toString())
                    val length = if (i % 5 == 0) 16.dp else 10.dp
                    val lineRadius = clockStyle.radius - length

                    val lineEndOffset = Offset(
                        x = (center.x + lineRadius.toPx() * cos(angleInRad)).toFloat(),
                        y = (center.y + lineRadius.toPx() * sin(angleInRad)).toFloat()
                    )

                    val lineStartOffset = Offset(
                        x = (center.x + clockStyle.radius.toPx() * cos(angleInRad)).toFloat(),
                        y = (center.y + clockStyle.radius.toPx() * sin(angleInRad)).toFloat()
                    )

                    drawLine(
                        Color.Black,
                        lineStartOffset,
                        lineEndOffset
                    )
                    if (i % 5 == 0) {
                        val textRadius = lineRadius.toPx() - clockStyle.textSize.toPx() + 5.dp.toPx()
                        val textX = (center.x + textRadius * cos(angleInRad)).toFloat()
                        val textY = (center.y + textRadius * sin(angleInRad)).toFloat()
                        val text = (if (i == 0) 12 else i / 5).toString()


                        val paint = Paint().apply {
                            textSize = clockStyle.textSize.toPx()
                            textAlign = Paint.Align.CENTER
                        }

                        paint.getTextBounds(text,0,text.length,rect)

                        drawText(
                            text,
                            textX - rect.exactCenterX(),
                            textY - rect.exactCenterY(),
                            Paint().apply {
                                textSize = clockStyle.textSize.toPx()
                            }
                        )
                    }
                }
                withRotation(
                    degrees = curHoursDegree,
                    pivotX = center.x,
                    pivotY = center.y
                ) {
                    Path().apply {
                        moveTo(hx, center.y)
                        lineTo(topPoint.x, topPoint.y)
                        lineTo(bottomPoint.x, bottomPoint.y)
                        lineTo(hx, center.y)
                        drawPath(
                            path = this,
                            color = Color.Black
                        )
                    }
                }
                withRotation(
                    degrees = minDegree,
                    pivotX = center.x,
                    pivotY = center.y
                ) {
                    Path().apply {
                        moveTo(mx, center.y)
                        lineTo(topPoint.x, topPoint.y)
                        lineTo(bottomPoint.x, bottomPoint.y)
                        lineTo(mx, center.y)
                        drawPath(
                            path = this,
                            color = Color.Black
                        )
                    }
                }

                withRotation(
                    degrees = secDegree,
                    pivotX = center.x,
                    pivotY = center.y
                ) {
                    Path().apply {
                        moveTo(sx, center.y)
                        lineTo(topPoint.x, topPoint.y - 4.dp.toPx())
                        lineTo(bottomPoint.x, bottomPoint.y - 4.dp.toPx())
                        lineTo(sx, center.y)
                        drawPath(
                            path = this,
                            color = clockStyle.secondsArrowColor
                        )
                    }
                }

            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewClockS() {
    AnimationComposeTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            ClockScreen(modifier = Modifier.align(Alignment.Center), clockStyle = ClockStyle())
        }
    }
}