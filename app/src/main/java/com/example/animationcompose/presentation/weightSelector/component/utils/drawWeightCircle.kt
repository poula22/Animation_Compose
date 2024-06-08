package com.example.animationcompose.presentation.weightSelector.component.utils

import android.graphics.Paint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.NativeCanvas

@RequiresApi(Build.VERSION_CODES.O)
fun NativeCanvas.drawWeightCircle(
    circleCenter: Offset,
    radius: Float,
    strokeWidth: Float
) {
    drawCircle(
        circleCenter.x,
        circleCenter.y,
        radius,
        Paint().apply {
            this.strokeWidth = strokeWidth
            color = android.graphics.Color.WHITE
            style = android.graphics.Paint.Style.STROKE
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
}