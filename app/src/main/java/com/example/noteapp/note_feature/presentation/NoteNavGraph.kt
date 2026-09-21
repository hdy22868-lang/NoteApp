package com.example.noteapp.note_feature.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.noteapp.note_feature.presentation.add_edit_note.component.AddEditNoteScreen
import com.example.noteapp.note_feature.presentation.notes.component.NotesScreen
import kotlinx.serialization.Serializable

@Serializable
object NotesScreenRoute
@Serializable
data class AddEditNoteRoute(
    val noteId: Int? = null,
    val noteColor: Int? = null
)

@Composable
fun NoteAppNavHost(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NotesScreenRoute
    ) {
        composable<NotesScreenRoute> {
            NotesScreen(
                onAddNoteClick = {navController.navigate(AddEditNoteRoute())},
                onEditNoteClick = { noteId, color ->
                    navController.navigate(
                        AddEditNoteRoute(
                            noteId = noteId,
                            noteColor = color
                        )
                    )
                }
            )
        }
        composable<AddEditNoteRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<AddEditNoteRoute>()
            AddEditNoteScreen(
                noteColor = route.noteColor ?: -1,
                onNavigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }
}