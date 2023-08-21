package com.example.healthyapp.utils

import android.content.Context

class SharedPrefManager(context: Context) {
    private val pref = context.getSharedPreferences("My Pref", Context.MODE_PRIVATE)
    private val edit = pref.edit()

    fun saveBoolean(isEntered: Boolean){
        edit.putBoolean("isEntered", isEntered)
        edit.apply()
    }

    fun getBoolean(): Boolean{
        return pref.getBoolean("isEntered", false)
    }
}