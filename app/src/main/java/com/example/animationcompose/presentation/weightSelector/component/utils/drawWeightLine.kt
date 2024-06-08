package com.example.animationcompose.presentation.weightSelector.component.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.example.animationcompose.presentation.weightSelector.model.LineType
import com.example.animationcompose.presentation.weightSelector.model.ScaleStyle
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun DrawScope.drawWeightLine(
    lineType: LineType,
    scaleStyle: ScaleStyle,
    angleInRad: Float,
    outerRadius: Float,
    circleCenter: Offset
) {
    val lineColor = when (lineType) {
        is LineType.TenStep -> scaleStyle.tenStepLineColor
        is LineType.FiveStep -> scaleStyle.fiveStepLineColor
        else -> scaleStyle.normalLineColor
    }

    val lineLength = when (lineType) {
        is LineType.TenStep -> scaleStyle.tenStepLineLength.toPx()
        is LineType.FiveStep -> scaleStyle.fiveStepLineLength.toPx()
        else -> scaleStyle.normalLineLength.toPx()
    }

    val startOffset = Offset(
        x = (outerRadius - lineLength) * cos(angleInRad) + circleCenter.x,
        y = (outerRadius - lineLength) * sin(angleInRad) + circleCenter.y
    )

    val endOffset = Offset(
        x = outerRadius * cos(angleInRad) + circleCenter.x,
        y = outerRadius * sin(angleInRad) + circleCenter.y
    )

    drawLine(
        color = lineColor,
        start = startOffset,
        end = endOffset,
        strokeWidth = 1.dp.toPx()
    )
}