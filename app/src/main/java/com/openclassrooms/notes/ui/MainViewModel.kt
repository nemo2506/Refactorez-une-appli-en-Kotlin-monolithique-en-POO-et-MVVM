package com.openclassrooms.notes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.data.model.Note

class MainViewModel : ViewModel() {
    private val notesLiveData = MutableLiveData<Note>()
    val user: LiveData<Note> get() = notesLiveData

    init {
        // trigger user load.
    }

    fun doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }
}