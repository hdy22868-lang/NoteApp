package com.example.noteapp.note_feature.presentation.notes

import com.example.noteapp.note_feature.domain.model.Note
import com.example.noteapp.note_feature.domain.util.NoteOrder
import com.example.noteapp.note_feature.domain.util.OrderType

data class NotesState(
    val notes: List<Note> =emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(orderType = OrderType.Descending),
    val isOrderSectionAvailable : Boolean = false
)
