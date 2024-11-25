package com.qguxxi.synthvoice.data.source.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface UserDao {

    @Update
    suspend fun updateUser(user : User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user : User)

    @Delete
    suspend fun deleteUser(user : User)

}