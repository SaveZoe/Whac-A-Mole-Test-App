package com.example.whac_a_mole.ui.screens.resultscreen

import androidx.lifecycle.ViewModel
import com.example.whac_a_mole.data.SharedPreferenceManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ResultViewModel : ViewModel() {
    private val _currentScore = MutableStateFlow(
        value = SharedPreferenceManager.getScore()
    )
    val currentScore: StateFlow<Int> = _currentScore

    private val _maxScore = MutableStateFlow(
        value = SharedPreferenceManager.getMaxScore()
    )
    val maxScore: StateFlow<Int> = _maxScore

    init {
        compareScore()
    }


    private fun compareScore() {
        if (_currentScore.value > _maxScore.value) {
            setMaxScore()
        }
    }

    private fun setMaxScore() {
        SharedPreferenceManager.setMaxScore(_currentScore.value)
    }
}