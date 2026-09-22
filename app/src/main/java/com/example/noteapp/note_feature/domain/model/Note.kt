package com.example.noteapp.note_feature.domain.model

import com.example.noteapp.ui.theme.BabyBlue
import com.example.noteapp.ui.theme.DarkGray
import com.example.noteapp.ui.theme.LightGreen
import com.example.noteapp.ui.theme.RedOrange
import com.example.noteapp.ui.theme.RedPink
import com.example.noteapp.ui.theme.Violet

data class Note(
    val id :Int? = null,
    val title: String,
    val content: String,
    val color : Int,
    val timestamp: Long
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}