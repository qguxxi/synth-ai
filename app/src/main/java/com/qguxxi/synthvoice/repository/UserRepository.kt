package com.qguxxi.synthvoice.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.qguxxi.synthvoice.data.source.local.User

interface UserRepository {
    suspend fun updateUser(user : User)

    suspend fun insertUser(user : User)

    suspend fun deleteUser(user : User)

}