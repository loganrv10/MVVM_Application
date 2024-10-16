package com.example.mvvmroomapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesViewModel(private val quotesRepository: QuotesRepository): ViewModel() {
    fun getQuotes(): LiveData<List<Quotes>>{
        return quotesRepository.getQuotes()
    }

    fun insertQuotes(quotes: Quotes){
        viewModelScope.launch(Dispatchers.IO) {
             quotesRepository.insertQuotes(quotes)
        }
    }
}