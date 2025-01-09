package com.alex.windows95.components.windowsmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.alex.windows95.ui.backgroundComponent
import com.alex.windows95.ui.windowsBlue

@Composable
fun WindowsMenuItem(text: String, painter: Painter) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val backgroundColor = if (isHovered) windowsBlue else backgroundComponent
    val textColor = if (isHovered) Color.White else Color.Black

    Row(
        modifier = Modifier
            .hoverable(interactionSource)
            .padding(4.dp)
            .fillMaxWidth()
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(6.dp))
        Image(
            modifier = Modifier.size(40.dp),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.width(6.dp))
        Text(
            text = text,
            color = textColor
        )
    }
}