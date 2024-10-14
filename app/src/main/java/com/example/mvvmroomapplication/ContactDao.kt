package com.example.mvvmroomapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {
    @Insert
   suspend fun insertContact(contact: Contact)
   @Delete
   suspend fun deleteContact(contact: Contact)
   @Update
   suspend fun updateContact(contact: Contact)

   @Query("SELECT * FROM contacts")
    fun getContact() : LiveData<List<Contact>>
}