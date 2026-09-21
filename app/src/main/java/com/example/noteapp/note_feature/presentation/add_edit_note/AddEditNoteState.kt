package com.example.noteapp.note_feature.presentation.add_edit_note

import androidx.compose.ui.graphics.toArgb
import com.example.noteapp.note_feature.domain.model.Note

data class AddEditNoteState(
    val noteTitle: String = "",
    val isTitleHintVisible: Boolean = true,
    val noteContent: String = "",
    val isContentHintVisible: Boolean = true,
    val noteColor: Int = Note.noteColors.random().toArgb()
)
