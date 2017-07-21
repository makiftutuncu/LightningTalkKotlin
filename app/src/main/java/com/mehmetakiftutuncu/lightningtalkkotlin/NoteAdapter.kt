package com.mehmetakiftutuncu.lightningtalkkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>() {
    val isEmpty: Boolean
        get() = notes.isEmpty()

    private var notes: MutableList<String> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val noteLayout = layoutInflater.inflate(R.layout.note_layout, parent, false)

        return NoteViewHolder(noteLayout)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]

        holder.setNote(note)
    }

    override fun getItemCount() = notes.size

    operator fun plusAssign(note: String) {
        notes.add(note)
        notifyDataSetChanged()
    }
}
