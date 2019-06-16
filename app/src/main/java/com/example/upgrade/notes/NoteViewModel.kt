package com.example.upgrade.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.upgrade.model.Note
import com.example.upgrade.model.NoteRoomDataBase
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

}