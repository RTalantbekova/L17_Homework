package com.example.l_homework.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoginData (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    var userName : String,
    var password : String
)