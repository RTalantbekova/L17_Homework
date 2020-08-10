package com.example.l_homework.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ETDao {
    @Insert
    fun insertEtData(data:EtData)

    @Query("SELECT * FROM EtData")
    fun getAllData() : List<EtData>
}