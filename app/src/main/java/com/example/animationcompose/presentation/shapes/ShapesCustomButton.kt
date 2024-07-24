package com.example.animationcompose.presentation.shapes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.animationcompose.core.navRoutes.Screens

@Composable
fun ShapesCustomButton(
    modifier: Modifier = Modifier,
    text:String,
    onNavigate: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        onClick = {
            onNavigate()
        }
    ) {
        Text(text = text, fontSize = 24.sp)
    }
}