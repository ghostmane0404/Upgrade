package com.example.upgrade.take_note

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.notes.*
import android.view.ViewTreeObserver
import android.R
import android.R.attr.start
import android.animation.Animator
import android.app.Activity
import android.view.ViewAnimationUtils

import android.os.Build
import android.text.TextUtils
import android.util.Log
import android.util.TypedValue
import com.example.upgrade.MainActivity
import kotlinx.android.synthetic.main.activity_take_note.*


class TakeNoteActivity : AppCompatActivity() {

    val TAG = "TakeNoteActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.upgrade.R.layout.activity_take_note)

        setSupportActionBar(noteToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        deleteNote.setOnClickListener { onBackPressed() }
        saveNote.setOnClickListener{
            val replyIntent = Intent()
            if (TextUtils.isEmpty(noteLabelInActivity.text) ||
                TextUtils.isEmpty(noteTextInActivity.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val label = noteLabelInActivity.text.toString()
                val text = noteTextInActivity.text.toString()
                replyIntent.putExtra("Reply_Label", label)
                replyIntent.putExtra("Reply_Text",text)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
            }


    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.home) {
            onBackPressed()

            Log.d(TAG,"Home pressed")
        }
        return super.onOptionsItemSelected(menuItem)
    }

}
