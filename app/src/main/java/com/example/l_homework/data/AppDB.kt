package com.example.l_homework.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EtData::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun getEtDao() : ETDao
}