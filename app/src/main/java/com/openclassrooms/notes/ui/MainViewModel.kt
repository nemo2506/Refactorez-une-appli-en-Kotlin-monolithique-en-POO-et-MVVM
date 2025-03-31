package com.openclassrooms.notes.ui

import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.data.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel : ViewModel() {

    private val notesRepository = NotesRepository()
    val notes: Flow<List<Note>> = notesRepository.notes

//    init {
//        collectNotes()
//    }

    /**
     * Collects notes from the repository and updates the state.
     */
//    private fun collectNotes() {
//    }
}