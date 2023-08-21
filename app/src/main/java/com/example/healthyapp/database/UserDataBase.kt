package com.example.healthyapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.healthyapp.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {
    abstract val dao: UserDao

    companion object {
        @Volatile
        private var instance: UserDataBase? = null

        operator fun invoke(context: Context): UserDataBase {
            return instance ?: synchronized(Any()) {
                instance ?: createDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun createDatabase(context: Context): UserDataBase {
            return Room.databaseBuilder(
                context,
                UserDataBase::class.java,
                "User.db"
            ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}