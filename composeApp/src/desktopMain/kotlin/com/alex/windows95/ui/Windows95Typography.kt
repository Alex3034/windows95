package com.alex.windows95.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.W95FA
import androidx.compose.material.Typography

@Composable
fun Windows95Typography(): Typography {
    val win95FontFamily = FontFamily(Font(Res.font.W95FA))

    return Typography(defaultFontFamily = win95FontFamily)
}