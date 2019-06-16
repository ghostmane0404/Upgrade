package com.example.upgrade.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.upgrade.model.Note
import com.example.upgrade.model.NoteDAO

class NoteRepository(private  val noteDao:NoteDAO) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    @WorkerThread
    suspend fun insert (note:Note)
    {
        noteDao.insert(note)
    }


}