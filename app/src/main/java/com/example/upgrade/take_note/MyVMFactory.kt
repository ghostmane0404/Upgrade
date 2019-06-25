package com.example.upgrade.take_note

import androidx.lifecycle.ViewModel
import android.app.Application
import androidx.lifecycle.ViewModelProvider


class MyVMFactory(private val mApplication: Application, private val noteId: String) :
    ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TakeNoteViewModel(mApplication, noteId) as T
    }
}