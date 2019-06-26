package com.example.upgrade.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.upgrade.model.Note
import com.example.upgrade.make_some_note.TakeNoteActivity
import kotlinx.android.synthetic.main.note_item.view.*




class NotesAdapter internal constructor(private val context:Context?): RecyclerView.Adapter<NotesAdapter.viewHolder>() {
    var notes = emptyList<Note>()
    var pos:Int = 0
    //var onItemClick: ((Note)->Unit) ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate(com.example.upgrade.R.layout.note_item,parent,false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.label.text = notes[position].labelNote
        holder.textNote.text = notes[position].textNote

        pos = position
        holder.itemView.setOnClickListener {
            val intent = Intent(context,TakeNoteActivity::class.java)
            intent.putExtra("id",notes[position].id)
            context?.startActivity(intent)
            Log.d("mylog", holder.textNote.text as String)
        }

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