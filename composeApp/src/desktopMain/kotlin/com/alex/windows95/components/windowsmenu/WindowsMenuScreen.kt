package com.alex.windows95.components.windowsmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alex.windows95.ui.backgroundComponent

@Composable
fun WindowsMenuScreen(showWindowsMenu: Boolean) {
    var subBarMenuPosition by remember { mutableStateOf<Float?>(null) }

    if (showWindowsMenu) {
        Column {
            Spacer(Modifier.weight(1f))
            Row {
                WindowsMenu { subBarMenuPosition = it }
                subBarMenuPosition?.let {
                    Box(
                        Modifier
                            .offset(y = it.dp)
                            .size(150.dp)
                            .background(backgroundComponent)
                    )
                }
            }
        }
    }
}