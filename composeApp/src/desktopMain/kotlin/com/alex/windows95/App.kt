package com.alex.windows95

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.alex.windows95.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var initializing: Boolean by remember { mutableStateOf(true) }

        Box(Modifier.fillMaxSize()) {
            if (initializing) {
                SplashScreen()
            } else {
                //Windows 95
            }
        }
    }
}