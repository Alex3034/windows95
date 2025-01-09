package com.alex.windows95.components.windowsmenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WindowsMenuScreen(showWindowsMenu: Boolean) {
    if (showWindowsMenu){
        Column {
            Spacer(Modifier.weight(1f))
            WindowsMenu()
        }
    }
}