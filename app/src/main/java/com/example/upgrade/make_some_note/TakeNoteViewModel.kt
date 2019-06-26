package com.example.upgrade.make_some_note

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.upgrade.model.Note
import com.example.upgrade.database.NoteRoomDataBase
import com.example.upgrade.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class TakeNoteViewModel(application: Application, noteId:String):AndroidViewModel(application){
    private  val TAG:String  = "ViewModel"
    private val repository:NoteRepository
    val singleNote:LiveData<Note>
    init{
        val notesDao = NoteRoomDataBase.getDatabase(application,viewModelScope).noteDao()
        repository = NoteRepository(notesDao)
        singleNote=	repository!!.getSingleNote(noteId)
        Log.d(TAG, "noteId is: $noteId")
    }

    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
    fun update(id:String,label:String,text:String) = viewModelScope.launch (Dispatchers.IO){
        repository.update(id,label,text)
    }
    fun delete(note:Note) = viewModelScope.launch (Dispatchers.IO){
        repository.delete(note)
    }
}