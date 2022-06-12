package com.example.whac_a_mole

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.whac_a_mole.data.SharedPreferenceManager
import com.example.whac_a_mole.navigation.Navigation
import com.example.whac_a_mole.ui.theme.WhacAMoleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        SharedPreferenceManager.initialize(context = applicationContext)
        super.onCreate(savedInstanceState)
        setContent {
            WhacAMoleTheme {
                Navigation()
            }
        }
    }
}