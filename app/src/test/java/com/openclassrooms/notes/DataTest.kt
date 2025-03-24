package com.openclassrooms.notes

import android.util.Log
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.data.repository.NotesRepository
import com.openclassrooms.notes.data.service.LocalNotesApiService
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNotSame
import junit.framework.TestCase.assertSame
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.first
import org.junit.Before
import org.junit.Test

class DataTest {

    private lateinit var repositoryNotes: List<Note>
    private lateinit var apiNotes: List<Note>

    @Before
    fun setUp() = runBlocking {
        repositoryNotes = NotesRepository().notes.first()  // Get fresh data
        apiNotes = LocalNotesApiService().getAllNotes()  // Get fresh data
    }

    @Test
    fun testNoteClassIsReady() {
        val titre = "access"
        val texte = "il est tiré du titre"
        val note = Note(titre, texte)

        assertEquals(titre, note.title)
        assertEquals(texte, note.body)
    }

    @Test
    fun testRepositoryIsProvided(): Unit = runBlocking {

        assertEquals(10, repositoryNotes.size)
    }

    @Test
    fun testLocalApiIsProvided(): Unit {

        assertEquals(10, apiNotes.size)
    }

    @Test
    fun testRepositoryIsSameToApi(): Unit = runBlocking {

        assertEquals(repositoryNotes.size, apiNotes.size)
        assertEquals("La vie est belle", apiNotes[0].title)
        assertEquals("Prenez soin de vous", apiNotes[7].title)
        assertEquals(repositoryNotes[0].title, apiNotes[0].title)
        assertEquals(repositoryNotes[7].title, apiNotes[7].title)
        assertEquals(repositoryNotes[1].body, apiNotes[1].body)
        assertEquals(repositoryNotes[6].body, apiNotes[6].body)
    }

}

