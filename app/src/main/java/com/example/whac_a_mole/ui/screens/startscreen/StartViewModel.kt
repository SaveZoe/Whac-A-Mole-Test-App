package com.example.whac_a_mole.ui.screens.startscreen

import androidx.lifecycle.ViewModel
import com.example.whac_a_mole.data.SharedPreferenceManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StartViewModel() : ViewModel() {
    private val _score = MutableStateFlow(
        value = SharedPreferenceManager.getMaxScore()
    )
    val score: StateFlow<Int> = _score
}