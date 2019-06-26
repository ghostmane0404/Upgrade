package com.example.upgrade.show_notes_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.upgrade.model.Note
import com.example.upgrade.database.NoteRoomDataBase
import com.example.upgrade.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application:Application):AndroidViewModel(application) {
    private var repository: NoteRepository?
    var allNotes:LiveData<List<Note>> ?

    init {
        val notesDao = NoteRoomDataBase.getDatabase(application,viewModelScope).noteDao()
        repository = NoteRepository(notesDao)
        allNotes = repository!!.allNotes
    }
    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository?.insert(note)
    }
    fun delete(note:Note) = viewModelScope.launch (Dispatchers.IO){
        repository?.delete(note)
    }
    fun deletebyid(id:String) = viewModelScope.launch (Dispatchers.IO){
        repository?.deletebyid(id)

    }
}