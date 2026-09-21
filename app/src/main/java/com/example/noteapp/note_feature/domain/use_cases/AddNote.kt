package com.example.noteapp.note_feature.domain.use_cases

import com.example.noteapp.note_feature.domain.model.Note
import com.example.noteapp.note_feature.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("عنوان الملاحظة لا يمكن أن يكون فارغاً.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("محتوى الملاحظة لا يمكن أن يكون فارغاً.")
        }
        repository.insertNote(note)
    }
}

class InvalidNoteException(message: String) : Exception(message)