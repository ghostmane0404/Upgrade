package com.example.upgrade.take_note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import android.R
import android.app.Activity

import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.upgrade.model.Note
import kotlinx.android.synthetic.main.activity_take_note.*


class TakeNoteActivity : AppCompatActivity() {
    private val TAG = "TakeNoteActivity"
     lateinit var  noteForDelete:Note
    private lateinit var takeNoteViewModel:TakeNoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.upgrade.R.layout.activity_take_note)
        setSupportActionBar(noteToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val noteId: Int = intent.getIntExtra("id", 999999)
        takeNoteViewModel = ViewModelProviders.of(this, MyVMFactory(this.application, noteId.toString()))
            .get(TakeNoteViewModel::class.java)
        if (noteId != 999999) {
          takeNoteViewModel.singleNote.observe(this, Observer {
                if (it.labelNote.isNullOrEmpty()) {
                    noteLabelInActivity.setText("")
                    noteTextInActivity.setText("")
                } else {
                    noteForDelete = it
                    noteLabelInActivity.setText(it.labelNote)
                    noteTextInActivity.setText(it.textNote)
                }
            })


            saveNote.setOnClickListener {
                //update
                takeNoteViewModel.update(
                    noteId.toString(),
                    noteLabelInActivity.text.toString(),
                    noteTextInActivity.text.toString()
                )
                Toast.makeText(this, "text has been changed", Toast.LENGTH_LONG).show()
                onBackPressed()
                finish()
            }
        } else {
            saveNote.setOnClickListener {
                val replyIntent = Intent()
                if (TextUtils.isEmpty(noteLabelInActivity.text) ||
                    TextUtils.isEmpty(noteTextInActivity.text)
                ) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val label = noteLabelInActivity.text.toString()
                    val text = noteTextInActivity.text.toString()
                    replyIntent.putExtra("Reply_Label", label)
                    replyIntent.putExtra("Reply_Text", text)
                    setResult(Activity.RESULT_OK, replyIntent)
                }
                Log.d(TAG, "1NoteId is " + noteId)
                finish()

            }
        }
        deleteNote.setOnClickListener {
            takeNoteViewModel.singleNote.removeObservers(this)
            takeNoteViewModel.delete(noteForDelete)
            Toast.makeText(this, "Note has been deleted", Toast.LENGTH_LONG).show()
            onBackPressed()

        }
    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.home) {
            onBackPressed()
            Log.d(TAG,"Home pressed")
        }
        return super.onOptionsItemSelected(menuItem)
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()

    }
}

