package com.alex.windows95.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.alex.windows95.ui.backgroundComponent
import kotlin.math.roundToInt

@Composable
fun WindowsButton(
    modifier: Modifier,
    dotPadding: Dp = 0.dp,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }

    Box(
        modifier
            .background(backgroundComponent)
            .drawBehind {
                val strokeWidth = 1.5f
                val spacing = 1.5f
                val with = size.width
                val height = size.height

                //Lateral izquierdo
                drawLine(
                    color = if (isPressed) Color.Black else Color.White,
                    start = Offset(0f, 0f),
                    end = Offset(0f, height),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    color = if (isPressed) Color.DarkGray else Color.White,
                    start = Offset(spacing, 0f),
                    end = Offset(spacing, height),
                    strokeWidth = strokeWidth
                )

                //Lateral superior
                drawLine(
                    color = if (isPressed) Color.Black else Color.White,
                    start = Offset(0f, 0f),
                    end = Offset(with, 0f),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    color = if (isPressed) Color.DarkGray else Color.White,
                    start = Offset(0f, spacing),
                    end = Offset(with, spacing),
                    strokeWidth = strokeWidth
                )

                //Lateral derecho
                drawLine(
                    color = if (isPressed) Color.White else Color.Black,
                    start = Offset(with, 0f),
                    end = Offset(with, height),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    color = if (isPressed) Color.White else Color.DarkGray,
                    start = Offset(with - spacing, 0f),
                    end = Offset(with - spacing, height),
                    strokeWidth = strokeWidth
                )

                //Lateral inferior
                drawLine(
                    color = if (isPressed) Color.White else Color.Black,
                    start = Offset(0f, height),
                    end = Offset(with, height),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    color = if (isPressed) Color.White else Color.DarkGray,
                    start = Offset(0f, height - spacing),
                    end = Offset(with, height - spacing),
                    strokeWidth = strokeWidth
                )

            }.pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        onClick()
                        isPressed = false
                    }
                )
            }.padding(dotPadding)
    ) {
        Box(
            modifier = Modifier
                .offset {
                    if (isPressed) {
                        val px = 2.dp.toPx().roundToInt()
                        IntOffset(px, px)
                    } else IntOffset.Zero
                }
                .drawBehind {
                    if (isPressed && dotPadding != 0.dp) {
                        drawRect(
                            color = Color.Black,
                            style = Stroke(
                                width = 2f,
                                pathEffect = PathEffect.dashPathEffect(
                                    floatArrayOf(2f, 2f),
                                    phase = 0f
                                )
                            )
                        )
                    }
                }
        ) {
            content()
        }
    }
}