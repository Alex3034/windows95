package com.alex.windows95.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.alex.windows95.model.FolderModel
import com.alex.windows95.ui.windowsBlue
import org.jetbrains.compose.resources.painterResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.ic_folder

@Composable
fun DraggableFolder(
    folderModel: FolderModel,
    onMove: (Offset) -> Unit,
    onTapFolder: (Int) -> Unit,
    onRename: (String) -> Unit,
    onDoubleTapFolder: (FolderModel) -> Unit
) {
    var offset by remember { mutableStateOf(folderModel.position) }
    val textColor = if (folderModel.selected) White else Black

    var newName by remember { mutableStateOf(folderModel.name) }
    var isEditing by remember { mutableStateOf(false) }
    var lastClickTime by remember { mutableStateOf(0L) }

    val focusRequester = remember { FocusRequester() }

    Box(
        Modifier
            .offset(x = folderModel.position.x.dp, y = folderModel.position.y.dp)
            .size(75.dp)
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, _, _ ->
                    offset = offset.copy(x = offset.x + pan.x, y = offset.y + pan.y)
                    onMove(offset)
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onTapFolder(folderModel.id)

                        val currentTime = System.currentTimeMillis()
                        val timeSinceLastClick = currentTime - lastClickTime
                        if (timeSinceLastClick in 300..800) {
                            isEditing = true
                        }
                        lastClickTime = currentTime
                    },
                    onPress = { onTapFolder(folderModel.id) },
                    onDoubleTap = { onDoubleTapFolder(folderModel) }
                )
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.size(50.dp)) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(Res.drawable.ic_folder),
                    contentDescription = "folder"
                )
                if (folderModel.selected) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(Res.drawable.ic_folder),
                        contentDescription = "folder selected",
                        tint = windowsBlue.copy(alpha = 0.4f)
                    )
                }
            }
            if (isEditing) {
                BasicTextField(
                    value = newName,
                    onValueChange = { newName = it },
                    modifier = Modifier.focusRequester(focusRequester),
                    singleLine = true,
                    maxLines = 1
                )
                LaunchedEffect(Unit){
                    focusRequester.requestFocus()
                }
            } else {
                Text(
                    text = folderModel.name,
                    color = textColor,
                    modifier = Modifier.background(if (folderModel.selected) windowsBlue else Color.Transparent)
                )
            }
        }
        if (isEditing) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                isEditing = false
                                onRename(newName)
                            }
                        )
                    }
            )
        }
    }
}

fun clearFolders(folders: List<FolderModel>): List<FolderModel> {
    val clearFolders = folders.map { it.copy(selected = false) }
    return clearFolders
}