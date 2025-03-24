package com.openclassrooms.notes.noteviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.data.Note

class NotesViewModel : ViewModel() {
    private val noteLiveData = MutableLiveData<Note>()
    val note: LiveData<Note> get() = noteLiveData

    init {
        // trigger user load.
    }

    fun doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }
}