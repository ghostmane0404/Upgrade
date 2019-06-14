package com.example.upgrade.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.upgrade.R
import com.example.upgrade.model.Note
import kotlinx.android.synthetic.main.note_item.view.*

class NotesAdapter(val context:Context?, val items:ArrayList<Note>): RecyclerView.Adapter<NotesAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate(R.layout.note_item,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.label.text = items.get(position).label
        holder.textNote.text = items.get(position).text
    }

    class viewHolder(view: View):RecyclerView.ViewHolder(view){
        val label = view.noteLabel
        val textNote  = view.noteText
    }
}