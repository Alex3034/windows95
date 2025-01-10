package com.alex.windows95.windows

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.alex.windows95.components.WindowBar
import com.alex.windows95.components.windowsmenu.WindowsMenuScreen
import com.alex.windows95.extensions.clickableWithoutRipple

@Composable
fun Windows95Screen() {

    var showWindowsMenu by remember { mutableStateOf(false) }

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clickableWithoutRipple { showWindowsMenu = false }
        ) {
            WindowsMenuScreen(showWindowsMenu)
        }
        WindowBar { showWindowsMenu = !showWindowsMenu }
    }
}