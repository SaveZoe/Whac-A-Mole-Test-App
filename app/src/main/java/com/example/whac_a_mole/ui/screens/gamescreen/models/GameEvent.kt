package com.example.whac_a_mole.ui.screens.gamescreen.models

sealed class GameEvent {
    data class ScoreChanged(val value: Int = 0) : GameEvent()
    data class LocationChanged(val value: Boolean) : GameEvent()
}
