package com.example.myapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao{
    @Insert
    suspend fun insertUser(user: User)

    @Query(
        value = "SELECT *FROM  users WHERE email AND password LIMIT 1"
    )
    suspend fun login(
        email:String,
        password:String
    ):User?

}