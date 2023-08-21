package com.example.healthyapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val familyName: String,
    val fathersName: String,
    val gender: String,
    val age: Int,
    val sickness: String,
    val date: String
)
