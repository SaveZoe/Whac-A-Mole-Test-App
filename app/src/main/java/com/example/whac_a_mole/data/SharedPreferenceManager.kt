package com.example.whac_a_mole.data

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceManager {
    private lateinit var shPreferences: SharedPreferences
    fun getMaxScore(): Int {
        return shPreferences.getInt("MaxScore", 0)
    }

    fun setMaxScore(score: Int) {
        shPreferences.edit().putInt("MaxScore", score).apply()
    }

    fun setScore(score: Int) {
        shPreferences.edit().putInt("Score", score).apply()
    }
    fun getScore(): Int {
        return shPreferences.getInt("Score", 0)
    }

    fun initialize(context: Context) {
        shPreferences = context.getSharedPreferences("WhacAMole", Context.MODE_PRIVATE)
    }
}