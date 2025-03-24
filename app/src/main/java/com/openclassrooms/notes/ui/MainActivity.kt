package com.openclassrooms.notes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.openclassrooms.notes.R
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.databinding.ActivityMainBinding
import com.openclassrooms.notes.widget.NoteItemDecoration
import com.openclassrooms.notes.widget.NotesAdapter
import kotlinx.coroutines.launch

/**
 * The main activity for the app.
 */
class MainActivity : AppCompatActivity() {

    /**
     * The binding for the main layout.
     */
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val notesAdapter = NotesAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initFABButton()
        collectNotes()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        viewModel.tasks.observe(this, ::updateNoteList)
    }

    /**
     * Observe notes from ViewModel
     */
    private fun collectNotes() {
        lifecycleScope.launch {
            viewModel.notes.collect { notesList ->
                notesAdapter.updateNotes(notesList)
            }
        }
    }

    /**
     * Initializes the FAB button.
     */
    private fun initFABButton() {
        binding.btnAdd.setOnClickListener {
            MaterialAlertDialogBuilder(this).apply {
                setTitle(R.string.coming_soon)
                setMessage(R.string.not_available_yet)
                setPositiveButton(android.R.string.ok, null)
            }.show()
        }
    }

    /**
     * Initializes the RecyclerView.
     */
    private fun initRecyclerView() {
        with(binding.recycler) {
            addItemDecoration(
                NoteItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.default_margin),
                    resources.getInteger(R.integer.span_count)
                )
            )
            adapter = notesAdapter
        }
    }

//    private fun updateNoteList(tasks: List<Note>) {
//        adapter.submitList(notes)
//    }

}
