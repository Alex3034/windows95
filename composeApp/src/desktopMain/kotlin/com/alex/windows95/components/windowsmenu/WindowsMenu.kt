package com.alex.windows95.components.windowsmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.windows95.components.BorderComponent
import com.alex.windows95.extensions.rotateVertically
import com.alex.windows95.ui.windowsBarTextBackground
import org.jetbrains.compose.resources.painterResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.ic_documents
import windows95.composeapp.generated.resources.ic_find
import windows95.composeapp.generated.resources.ic_help
import windows95.composeapp.generated.resources.ic_programs
import windows95.composeapp.generated.resources.ic_run
import windows95.composeapp.generated.resources.ic_settings
import windows95.composeapp.generated.resources.ic_shutdown

@Composable
fun WindowsMenu(showSubMenu: (Float?) -> Unit) {
    BorderComponent(Modifier.height(350.dp)) {
        Column {
            Row {
                Column {
                    Spacer(Modifier.weight(1f))
                    Box(
                        modifier = Modifier.padding(start = 4.dp, top = 4.dp)
                            .fillMaxHeight()
                            .background(windowsBarTextBackground)
                            .padding(4.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Text(
                            text = "Windows 95",
                            modifier = Modifier.rotateVertically(false),
                            fontSize = 42.sp
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(200.dp)
                ) {
                    WindowsMenuItem(
                        text = "Programs",
                        painter = painterResource(Res.drawable.ic_programs),
                        expandable = true
                    ) { showSubMenu(it) }
                    WindowsMenuItem(
                        text = "Documents",
                        painter = painterResource(Res.drawable.ic_documents),
                        expandable = true
                    ) { showSubMenu(it) }
                    WindowsMenuItem(
                        text = "Settings",
                        painter = painterResource(Res.drawable.ic_settings),
                        expandable = true
                    ) { showSubMenu(it) }
                    WindowsMenuItem(
                        text = "Find",
                        painter = painterResource(Res.drawable.ic_find),
                        expandable = true
                    ) { showSubMenu(it) }
                    WindowsMenuItem(
                        text = "Help",
                        painter = painterResource(Res.drawable.ic_help)
                    ) { showSubMenu(it) }
                    WindowsMenuItem(
                        text = "Run...",
                        painter = painterResource(Res.drawable.ic_run)
                    ) { showSubMenu(it) }
                    //DIVIDER
                    WindowsMenuItem(
                        text = "Shut Down...",
                        painter = painterResource(Res.drawable.ic_shutdown)
                    ) { showSubMenu(it) }
                }
            }
        }
    }
}