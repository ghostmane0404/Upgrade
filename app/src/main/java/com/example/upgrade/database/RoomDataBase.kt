package com.example.upgrade.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.upgrade.dao.NoteDAO
import com.example.upgrade.dao.WeatherDAO
import com.example.upgrade.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Note::class],version = 1)
 abstract  class NoteRoomDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDAO
    abstract fun weatherDao():WeatherDAO
    companion object {
        @Volatile
        private var INSTANCE: NoteRoomDataBase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): NoteRoomDataBase {
            return INSTANCE ?: synchronized(this) {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteRoomDataBase::class.java,
                        "Room_database"
                    )
                        .addCallback(NoteDatabaseCallback(scope))
                        .build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
    private class NoteDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.noteDao())
                }
            }
        }
        suspend fun populateDatabase(noteDao: NoteDAO) {
            //noteDao.deleteAll()
//            var note = Note("Hello","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
//            noteDao.insert(note)
//            note = Note("World!","etbtstrbsrtnbmtsrkot;rnbs;rjntslrnbttr")
//            noteDao.insert(note)
        }
    }






}