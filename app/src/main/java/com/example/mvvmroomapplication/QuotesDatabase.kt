package com.example.mvvmroomapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quotes::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {
    abstract fun quotesDao(): QuotesDao

    companion object {
        @Volatile
        private var INSTANCE: QuotesDatabase? = null
        fun getInstance(context: Context): QuotesDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, QuotesDatabase::class.java, "quotes_database"
                    ).createFromAsset("quotes.json").build()
                }
            }
            return INSTANCE!!
        }
    }

}