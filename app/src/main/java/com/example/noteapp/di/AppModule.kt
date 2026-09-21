package com.example.noteapp.di

import androidx.room.Room
import com.example.noteapp.note_feature.data.local.NoteDatabase
import com.example.noteapp.note_feature.data.repository.NoteRepositoryImpl
import com.example.noteapp.note_feature.domain.repository.NoteRepository
import com.example.noteapp.note_feature.domain.use_cases.*
import com.example.noteapp.note_feature.presentation.add_edit_note.AddEditNoteViewModel
import com.example.noteapp.note_feature.presentation.notes.NotesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<NoteDatabase> {
        Room.databaseBuilder(
            get<android.app.Application>(),
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }
    single {
        get<NoteDatabase>().noteDao
    }

    singleOf(::NoteRepositoryImpl).bind<NoteRepository>()

    singleOf(::GetNotes)
    singleOf(::DeleteNote)
    singleOf(::AddNote)
    singleOf(::GetNote)

    singleOf(::NoteUseCases)

    viewModelOf(::NotesViewModel)

    viewModel {
        AddEditNoteViewModel(get(), savedStateHandle = get())
    }
}