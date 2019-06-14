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
import android.view.ViewAnimationUtils

import android.os.Build
import android.util.Log
import android.util.TypedValue
import com.example.upgrade.MainActivity
import kotlinx.android.synthetic.main.activity_take_note.*


class TakeNoteActivity : AppCompatActivity() {

    val TAG = "TakeNoteActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.upgrade.R.layout.activity_take_note)
        overridePendingTransition(com.example.upgrade.R.anim.do_not_move, com.example.upgrade.R.anim.do_not_move)
        setSupportActionBar(noteToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        deleteNote.setOnClickListener { onBackPressed() }
        saveNote.setOnClickListener{onBackPressed()}
    }
    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) {
            onBackPressed()

            Log.d(TAG,"Home pressed")
        }
        return super.onOptionsItemSelected(menuItem)
    }

}
