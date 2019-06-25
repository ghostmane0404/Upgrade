package com.example.upgrade.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO{
    @Insert
    suspend fun insert(note:Note)

    @Query("Delete FROM note_table")
    fun deleteAll()

    @Query("SELECT * from note_table Order by labelNote asc")
    fun getAllNotes():LiveData<List<Note>>

    @Query( "Update note_table set labelNote =:label, text = :text where id = :id ")
    suspend fun update(id:String,label:String,text:String)

    @Query("SELECT * FROM note_table WHERE id = :id ")
    fun loadSingle(id: String): LiveData<Note>

    @Query("Delete from note_table where id = :id")
    fun deletebyid(id:String)

    @Delete
    fun delete(note:Note)
}