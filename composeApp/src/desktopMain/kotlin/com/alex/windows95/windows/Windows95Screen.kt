package com.alex.windows95.windows

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import com.alex.windows95.components.DraggableFolder
import com.alex.windows95.components.DraggableWindow
import com.alex.windows95.components.WindowBar
import com.alex.windows95.components.clearFolders
import com.alex.windows95.components.windowsmenu.WindowsMenuScreen
import com.alex.windows95.extensions.clickableWithoutRipple
import com.alex.windows95.model.FolderModel
import com.alex.windows95.model.WindowModel

@Composable
fun Windows95Screen() {

    var showWindowsMenu by remember { mutableStateOf(false) }
    val fakeFolder = FolderModel(0, "Alejandro", Offset(x = 0f, y = 0f))
    var folders by remember { mutableStateOf(listOf<FolderModel>(fakeFolder)) }
    var windows by remember { mutableStateOf(listOf<WindowModel>()) }

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clickableWithoutRipple {
                    showWindowsMenu = false
                    folders = clearFolders(folders)
                }
        ) {
            folders.forEach { folder ->
                DraggableFolder(
                    folderModel = folder,
                    onMove = { newPosition ->
                        folders = folders.map {
                            if (it.id == folder.id) it.copy(position = newPosition) else it
                        }
                    },
                    onTapFolder = { id ->
                        folders = folders.map { if (id == it.id) it.copy(selected = true) else it }
                    },
                    onRename = { newName ->
                        folders = folders.map {
                            if (it.id == folder.id) it.copy(name = newName) else it
                        }
                    },
                    onDoubleTapFolder = { selectedFolder ->
                        val newWindow = WindowModel(
                            id = selectedFolder.id,
                            title = selectedFolder.name,
                            position = Offset(100f, 100f)
                        )
                        windows = windows + newWindow
                    })
            }
            WindowsMenuScreen(showWindowsMenu)
            windows.filter { !it.minimized }.forEach { window ->
                key(window.id) {
                    DraggableWindow(window)
                }
            }
        }
        WindowBar { showWindowsMenu = !showWindowsMenu }
    }
}