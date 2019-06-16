package com.example.upgrade.notes

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upgrade.adapters.NotesAdapter

import com.example.upgrade.model.Note
import com.example.upgrade.take_note.TakeNoteActivity
import kotlinx.android.synthetic.main.notes.*
import android.R



class NotesFragment: Fragment(),NotesContract.NotesView {
    private lateinit var noteViewModel: NoteViewModel
    val TAG = "NotesFragment"
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG,"onATtach")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG,"onCreateView")
        return inflater.inflate(com.example.upgrade.R.layout.notes,null)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //fab opens new activity
        fab.setOnClickListener {
            startActivityForResult( Intent(context,TakeNoteActivity::class.java),newNoteActivityRequestCode)//,newNoteActivityRequestCode)
        }
        Log.d(TAG,"FAB is pressed!  ")
        ////////////adapter for notes
        var n = NotesAdapter(context)
        notes_recycler.layoutManager = LinearLayoutManager(context)
        notes_recycler.adapter = n
        //////ViewModel init
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.allNotes?.observe(this, Observer { notes ->
            notes?.let {n.setNotes(it)}
        })
        Log.d(TAG,"onViewCreated"+ noteViewModel.allNotes)

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
    companion object {
        const val newNoteActivityRequestCode = 1
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode==1 && resultCode ==Activity.RESULT_OK)
        {
            data?.let{
                val note = Note(it.getStringExtra("Reply_Label"),it.getStringExtra("Reply_Text"))
                noteViewModel.insert(note)
            }
        }
        else {
            Toast.makeText(
                context,
                "note not saved",
                Toast.LENGTH_LONG).show()
        }
    }
}