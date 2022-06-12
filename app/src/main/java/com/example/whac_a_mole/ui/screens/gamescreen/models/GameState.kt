package com.example.whac_a_mole.ui.screens.gamescreen.models

import androidx.compose.runtime.Stable

@Stable
data class GameState(
    val score: Int = 0,
    val seeMole1: Boolean = false,
    val seeMole2: Boolean = false,
    val seeMole3: Boolean = false,
    val seeMole4: Boolean = false,
    val seeMole5: Boolean = false,
    val seeMole6: Boolean = false,
    val seeMole7: Boolean = false,
    val seeMole8: Boolean = false,
    val seeMole9: Boolean = false,
    val totalSeconds: Int = 0,
)