package com.example.animationcompose.presentation.weightSelector

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationcompose.presentation.weightSelector.component.WeightElement

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeightSelectorScreen(
    modifier: Modifier = Modifier,
) {
    var weight by remember {
        mutableIntStateOf(80)
    }
    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {
            Text(
                modifier = modifier.align(Alignment.Center),
                text = "Select Your Weight",
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal
            )

            Row(
                modifier = modifier
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = weight.toString(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(
                    modifier = modifier.width(width = 4.dp)
                )
                Text(
                    text = "KG",
                    fontSize = 30.sp,
                    color = Color(0xFF3AB241),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        WeightElement(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 50.dp)
                .align(Alignment.Center),
        ) {
            weight = it
        }
    }
}