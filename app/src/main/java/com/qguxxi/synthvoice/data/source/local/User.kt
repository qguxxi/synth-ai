package com.qguxxi.synthvoice.data.source.local

import androidx.room.PrimaryKey


data class User(
    @PrimaryKey(autoGenerate = true)
    val idToken : Int,
    val gmail: String,
)