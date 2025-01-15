package com.alex.windows95.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.alex.windows95.model.WindowModel

@Composable
fun DraggableWindow(windowModel: WindowModel) {
    BorderComponent(Modifier.offset {
        IntOffset(windowModel.position.x.toInt(), windowModel.position.y.toInt())
    }) {
        Column(Modifier.size(100.dp).background(Color.White)) {
            Text(windowModel.title)
        }
    }
}