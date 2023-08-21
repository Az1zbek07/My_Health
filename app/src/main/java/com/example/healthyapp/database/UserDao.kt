package com.example.healthyapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.healthyapp.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveUser(user: User)

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAllUsers(): List<User>
}