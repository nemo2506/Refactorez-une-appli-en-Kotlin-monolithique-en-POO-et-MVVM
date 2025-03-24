package com.openclassrooms.notes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.data.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {
//    private val notesLiveData = MutableLiveData<Note>()
//    val notes: LiveData<Note> get() = notesLiveData
    val notes: Flow<List<Note>> = NotesRepository().notes

    init {
        // trigger user load.
    }

    fun doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }
}