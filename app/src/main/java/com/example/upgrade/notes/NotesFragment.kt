package com.example.upgrade.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.upgrade.R
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upgrade.adapters.NotesAdapter

import com.example.upgrade.model.Note
import com.example.upgrade.take_note.TakeNoteActivity
import kotlinx.android.synthetic.main.notes.*

class NotesFragment: Fragment(),NotesContract.NotesView {
    val TAG = "NotesFragment"
    var wf = 30
    var notes:ArrayList<Note> = ArrayList()
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG,"onATtach")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")

        view?.setOnClickListener {
            Log.d(TAG,"FAB is pressed!  ")

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG,"onCreateView")
        return inflater.inflate(R.layout.notes,null)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener { startActivity( Intent(context,TakeNoteActivity::class.java)) }
        addNotes()
        notes_recycler.layoutManager = LinearLayoutManager(context)
        notes_recycler.adapter = NotesAdapter(context,notes)
        Log.d(TAG,"onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG,"onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroyView ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"onDetach ")
    }
    private fun addNotes(){
        val note = Note()
        note.label="lorem ipsum"
        note.text= "wgrerhokrpoehemlbtpergmeprgpeprgmekrgmeg;lerg"
        notes.add(note)
        notes.add(note)
        notes.add(note)
        notes.add(note)
        notes.add(note)
        notes.add(note)
        notes.add(note)
        notes.add(note)
        notes.add(note)
    }




}