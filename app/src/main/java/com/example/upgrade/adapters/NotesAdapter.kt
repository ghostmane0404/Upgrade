package com.example.upgrade.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.upgrade.R
import com.example.upgrade.model.Note
import kotlinx.android.synthetic.main.note_item.view.*

class NotesAdapter internal constructor(private val context:Context?): RecyclerView.Adapter<NotesAdapter.viewHolder>() {
    private var notes = emptyList<Note>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        return viewHolder(LayoutInflater.from(context).inflate(R.layout.note_item,parent,false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.label.text = notes.get(position).label
        holder.textNote.text = notes.get(position).textNote
    }
    internal fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }
    class viewHolder(view: View):RecyclerView.ViewHolder(view){
        val label = view.noteLabel
        val textNote  = view.noteText
    }
    
}