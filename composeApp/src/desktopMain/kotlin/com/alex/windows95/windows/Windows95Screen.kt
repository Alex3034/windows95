package com.alex.windows95.windows

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alex.windows95.components.WindowBar

@Composable
fun Windows95Screen() {
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        WindowBar()
    }
}