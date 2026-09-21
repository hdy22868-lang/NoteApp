package com.example.noteapp.note_feature.data.mapper

import com.example.noteapp.note_feature.data.local.NoteEntity
import com.example.noteapp.note_feature.domain.model.Note

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        timestamp = timestamp,
        color = color
    )
}

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        content = content,
        timestamp = timestamp,
        color = color
    )
}