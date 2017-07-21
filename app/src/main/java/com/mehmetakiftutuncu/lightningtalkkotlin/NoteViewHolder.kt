package com.mehmetakiftutuncu.lightningtalkkotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.note_layout.view.note

class NoteViewHolder(noteLayout: View) : RecyclerView.ViewHolder(noteLayout) {
    private val noteView: TextView = noteLayout.note

    fun setNote(note: String) {
        noteView.text = note
    }
}
