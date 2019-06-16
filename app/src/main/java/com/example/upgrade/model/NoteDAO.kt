package com.example.upgrade.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDAO{
    @Insert
    suspend fun insert(note:Note)

    @Query("Delete FROM note_table")
    fun deleteAll()
    @Query("SELECT * from note_table Order by label asc")
    fun getAllNotes():LiveData<List<Note>>
}