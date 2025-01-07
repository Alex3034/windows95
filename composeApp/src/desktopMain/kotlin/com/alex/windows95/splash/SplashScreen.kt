package com.alex.windows95.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.splash

@Composable
fun SplashScreen() {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(Res.drawable.splash),
        contentDescription = "Windows95 Splash",
        contentScale = ContentScale.Crop
    )
}