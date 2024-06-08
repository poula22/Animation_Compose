package com.example.animationcompose.presentation.weightSelector.component.utils

import android.graphics.Paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.NativeCanvas
import com.example.animationcompose.presentation.weightSelector.model.LineType
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

fun NativeCanvas.drawWeightText(
    text: String,
    textSize: Float,
    x: Float,
    y: Float
) {
    drawText(
        text,
        x,
        y,
        Paint().apply {
            this.textSize = textSize
            textAlign = Paint.Align.CENTER
        }
    )
}