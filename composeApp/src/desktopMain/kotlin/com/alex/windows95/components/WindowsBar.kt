package com.alex.windows95.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alex.windows95.ui.backgroundComponent
import com.alex.windows95.ui.windowsBlue

@Composable
fun WindowBar() {
    Column {
        Box(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.White)
        )
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .background(backgroundComponent)
        ) {
            Box(
                Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight()
                    .width(80.dp)
                    .background(windowsBlue)
            )
            Row(modifier = Modifier.weight(1f)) { }
            InformationBar()
        }
    }
}