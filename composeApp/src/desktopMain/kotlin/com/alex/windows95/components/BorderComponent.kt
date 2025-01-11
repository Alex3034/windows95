package com.alex.windows95.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.alex.windows95.ui.backgroundComponent

@Composable
fun BorderComponent(modifier: Modifier, content: @Composable () -> Unit) {
    Box(modifier
        .background(backgroundComponent)
        .drawBehind {
            val strokeWidth = 1.5f
            val spacing = 1.5f
            val with = size.width
            val height = size.height

            //Lateral izquierdo
            drawLine(
                color = Color.White,
                start = Offset(0f, 0f),
                end = Offset(0f, height),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = Color.White,
                start = Offset(spacing, 0f),
                end = Offset(spacing, height),
                strokeWidth = strokeWidth
            )

            //Lateral superior
            drawLine(
                color = Color.White,
                start = Offset(0f, 0f),
                end = Offset(with, 0f),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = Color.White,
                start = Offset(0f, spacing),
                end = Offset(with, spacing),
                strokeWidth = strokeWidth
            )

            //Lateral derecho
            drawLine(
                color = Color.Black,
                start = Offset(with, 0f),
                end = Offset(with, height),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = Color.DarkGray,
                start = Offset(with - spacing, 0f),
                end = Offset(with - spacing, height),
                strokeWidth = strokeWidth
            )

            //Lateral inferior
            drawLine(
                color = Color.Black,
                start = Offset(0f, height),
                end = Offset(with, height),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = Color.DarkGray,
                start = Offset(0f, height - spacing),
                end = Offset(with, height - spacing),
                strokeWidth = strokeWidth
            )

        }
    ) { content() }
}