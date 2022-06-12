package com.example.whac_a_mole.common

interface ViewRender<T> {
    fun render(state: T)
}