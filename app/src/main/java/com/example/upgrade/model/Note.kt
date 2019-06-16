package com.example.upgrade.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
class Note(@PrimaryKey @ColumnInfo(name = "label") var label: String, @ColumnInfo(name = "text") var textNote:String)