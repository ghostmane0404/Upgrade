package com.example.upgrade.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.upgrade.model.Note
import com.example.upgrade.dao.NoteDAO

class NoteRepository(private  val noteDao: NoteDAO) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()
    @WorkerThread
    suspend fun insert (note:Note)
    {
        noteDao.insert(note)
    }
    @WorkerThread
    suspend fun update (id:String,label:String,text:String)
    {
        noteDao.update(id,label,text)
    }
    @WorkerThread
    suspend fun delete(note:Note)
    {
        noteDao.delete(note)
    }
    @WorkerThread
    suspend fun deletebyid(id:String)
    {
        noteDao.deletebyid(id)
    }
    fun getSingleNote(id:String) :LiveData<Note>  = noteDao.loadSingle(id)






}