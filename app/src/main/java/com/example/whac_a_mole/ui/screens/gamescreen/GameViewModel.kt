package com.example.whac_a_mole.ui.screens.gamescreen

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whac_a_mole.common.ViewRender
import com.example.whac_a_mole.data.SharedPreferenceManager
import com.example.whac_a_mole.ui.screens.gamescreen.models.GameEvent
import com.example.whac_a_mole.ui.screens.gamescreen.models.GameState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Thread.State
import java.util.*
import kotlin.random.Random

class GameViewModel : ViewModel(), ViewRender<GameEvent> {

    private val _viewState = MutableStateFlow(GameState())
    val viewState: StateFlow<GameState> = _viewState

    private val _timer = MutableStateFlow(30)
    val timer: StateFlow<Int> = _timer

    override fun render(state: GameEvent) {
        when (state) {
            is GameEvent.ScoreChanged -> scoreChange(state.value)
            else -> {}
        }
    }

    fun saveResult(value: Int) {
        SharedPreferenceManager.setScore(value)
    }

    fun timer(): CountDownTimer = object : CountDownTimer(30 * 1000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            _viewState.value = _viewState.value.copy(totalSeconds = _timer.value - 1)
            _timer.value = timer.value - 1
        }

        override fun onFinish() {
            _viewState.value = _viewState.value
        }
    }.start()


    fun random() {
        val random = Random.nextInt(from = 1, until = 10)
        _viewState.value = when (random) {
            1 -> _viewState.value.copy(seeMole1 = true)
            2 -> _viewState.value.copy(seeMole2 = true)
            3 -> _viewState.value.copy(seeMole3 = true)
            4 -> _viewState.value.copy(seeMole4 = true)
            5 -> _viewState.value.copy(seeMole5 = true)
            6 -> _viewState.value.copy(seeMole6 = true)
            7 -> _viewState.value.copy(seeMole7 = true)
            8 -> _viewState.value.copy(seeMole8 = true)
            9 -> _viewState.value.copy(seeMole9 = true)
            else -> _viewState.value.copy()
        }
    }

    fun startState() {
        _viewState.value = _viewState.value.copy(
            seeMole1 = false,
            seeMole2 = false,
            seeMole3 = false,
            seeMole4 = false,
            seeMole5 = false,
            seeMole6 = false,
            seeMole7 = false,
            seeMole8 = false,
            seeMole9 = false,
        )
    }

    private fun scoreChange(value: Int) {
        _viewState.value = _viewState.value.copy(score = value)
        startState()
    }
}