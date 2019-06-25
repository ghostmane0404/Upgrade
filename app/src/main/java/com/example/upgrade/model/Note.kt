package com.example.upgrade.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
class Note(@ColumnInfo(name = "labelNote") var labelNote: String, @ColumnInfo(name = "text") var textNote:String)
{
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = 0






}