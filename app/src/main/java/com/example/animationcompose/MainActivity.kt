package com.example.animationcompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.animationcompose.presentation.clock.ClockScreen
import com.example.animationcompose.presentation.clock.model.ClockStyle
import com.example.animationcompose.core.ui.theme.AnimationComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationComposeTheme {
                WindowCompat.setDecorFitsSystemWindows(window,false)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Navigation()
                    Box(modifier = Modifier.fillMaxSize()) {
                        ClockScreen(modifier = Modifier.align(Alignment.Center),clockStyle = ClockStyle())
                    }
                }
            }
        }
    }
}