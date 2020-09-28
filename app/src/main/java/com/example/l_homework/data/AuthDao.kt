package com.example.l_homework.data

import androidx.room.*

@Dao
interface AuthDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data : LoginData)
    @Query("Select * from LoginData where userName = :logText AND password = :passText")
    fun getUser(logText : String, passText : String) : LoginData

    @Query("Select * from LoginData")
    fun getAllList() : List<LoginData>

    @Query("Delete from LoginData")
    fun deleteAll()

    @Transaction()
    fun addAndDelete(data : LoginData)
    {
        deleteAll()
        insertData(data)
    }

}