<<<<<<< HEAD:app/src/main/java/com/openclassrooms/notes/ui/widget/NoteViewHolder.kt
package com.openclassrooms.notes.ui.widget

import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.databinding.NoteBinding

/**
 * A view holder for displaying a note in a RecyclerView.
 * @param binding The binding for the note layout.
 */
class NoteViewHolder(private val binding: NoteBinding): RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the view holder to a note.
     * @param note The note to bind to the view holder.
     */
    fun bind(note: Note) {
        binding.title.text = note.title
        binding.body.text = note.body
    }

=======
package com.openclassrooms.notes.widget

import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.databinding.NoteBinding

/**
 * A view holder for displaying a note in a RecyclerView.
 * @param binding The binding for the note layout.
 */
class NoteViewHolder(private val binding: NoteBinding): RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the view holder to a note.
     * @param note The note to bind to the view holder.
     */
    fun bind(note: Note) {
        binding.title.text = note.title
        binding.body.text = note.body
    }

>>>>>>> 73203077f385f2c8c358af948e58a0633883c9b9:app/src/main/java/com/openclassrooms/notes/widget/NoteViewHolder.kt
}