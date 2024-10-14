package com.example.mvvmroomapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDB : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        private var INSTANCE: ContactDB? = null
        fun getDatabase(context: Context): ContactDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,ContactDB::class.java, "contact_database")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}