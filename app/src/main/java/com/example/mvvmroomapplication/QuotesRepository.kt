package com.example.mvvmroomapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuotesRepository(private val quotesDao: QuotesDao) {

    fun getQuotes() : LiveData<List<Quotes>> {
        return quotesDao.getQuotes()
    }

    suspend fun insertQuotes(quotes: Quotes){
        quotesDao.addQuotes(quotes)
    }

    suspend fun deleteQuotes(quotes: Quotes){
        quotesDao.deleteQuotes(quotes)
    }

}