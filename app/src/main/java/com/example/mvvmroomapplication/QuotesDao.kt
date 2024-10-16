package com.example.mvvmroomapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuotesDao {

    @Query("SELECT * FROM quotes")
    fun getQuotes(): LiveData<List<Quotes>>

    @Insert
   suspend fun addQuotes(quotes: Quotes)

    @Delete
   suspend fun deleteQuotes(quotes: Quotes)
}