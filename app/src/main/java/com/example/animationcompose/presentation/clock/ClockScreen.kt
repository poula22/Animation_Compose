package com.example.animationcompose.presentation.clock

import android.graphics.Paint
import android.icu.util.Calendar
import android.os.Build
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withRotation
import com.example.animationcompose.presentation.clock.model.ClockStyle
import java.util.Date
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ClockScreen(
    modifier: Modifier = Modifier,
    curTime: Date = Calendar.getInstance().time,
    clockStyle: ClockStyle
) {

    val hoursDegree by remember {
        mutableFloatStateOf(0f)
    }
    val minDegree by remember {
        mutableFloatStateOf(0f)
    }
    val secDegree by remember {
        mutableFloatStateOf(0f)
    }

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = modifier.fillMaxWidth()) {
            drawContext.canvas.nativeCanvas.apply {
                val curHoursDegree = hoursDegree - clockStyle.hoursInitialDegree
                val curHourDegreeInRad = curHoursDegree * (PI / 180f)
                val x = (clockStyle.radius.toPx() * cos(curHourDegreeInRad)).toFloat() + center.x
                val y = (clockStyle.radius.toPx() * sin(curHourDegreeInRad)).toFloat() + center.y
                val innerRadius = 4.dp.toPx()
                val topPoint = Offset(
                    x = center.x,
                    y = center.y + (innerRadius * sin(curHourDegreeInRad)).toFloat()
                )
                val bottomPoint = Offset(
                    x = center.x,
                    y = center.y - (innerRadius * sin(curHourDegreeInRad)).toFloat()
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
                withRotation(
                    degrees = curHoursDegree,
                    pivotX = center.x,
                    pivotY = center.y
                ) {
                    Path().apply {
                        moveTo(x, y)
                        lineTo(topPoint.x,topPoint.y)
                        lineTo(bottomPoint.x,bottomPoint.y)
                        lineTo(x,y)
                        drawPath(
                            path = this,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}