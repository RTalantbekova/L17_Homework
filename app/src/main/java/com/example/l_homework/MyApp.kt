package com.example.l_homework

import android.app.Application
import androidx.room.Room
import com.example.l_homework.data.AppDB

class MyApp : Application() {

    private var db: AppDB? = null

    override fun onCreate() {
        super.onCreate()
        app = this
        db = Room.databaseBuilder(this, AppDB::class.java, "My_Database")
            .allowMainThreadQueries()
            .build()
    }

    fun getDB() : AppDB? {
        return db
    }

    companion object{
        var app : MyApp? = null
    }
}