package com.mehmetakiftutuncu.lightningtalkkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_notes.*
import java.util.*

class NotesActivity : AppCompatActivity() {
    private val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = noteAdapter

        val random = Random()
        addNoteButton.setOnClickListener {
            addNote("Random note ${random.nextInt(1000)}")
        }

        updateNotes()
    }

    private fun addNote(note: String) {
        noteAdapter += note

        updateNotes()
    }

    private fun updateNotes() {
        val empty = noteAdapter.isEmpty

        emptyMessage.visibility = if (empty) View.VISIBLE else View.GONE
        recyclerView.visibility = if (empty) View.GONE else View.VISIBLE
    }
}
