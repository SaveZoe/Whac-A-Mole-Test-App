package com.example.whac_a_mole.ui.screens.resultscreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.whac_a_mole.R
import com.example.whac_a_mole.navigation.NavRoute
import com.example.whac_a_mole.ui.theme.WhacAMoleTheme

@Composable
fun ResultScreen(navController: NavController, viewModel: ResultViewModel = viewModel()) {

    val score = viewModel.currentScore.collectAsState(0).value
    val maxScore = viewModel.maxScore.collectAsState(0).value

    Log.d("test", "ResultScreen: $score, $maxScore")

    ResultScreenContent(
        menuClick = { navController.navigate(NavRoute.StartScreen.name) },
        playAgainClick = { navController.navigate(NavRoute.GameScreen.name) },
        score = score,
        maxScore = maxScore
    )
}

@Composable
fun ResultScreenContent(
    menuClick: () -> Unit,
    playAgainClick: () -> Unit,
    score: Int,
    maxScore: Int
) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.YourScore) + score)
            Text(text = stringResource(R.string.YourMaxScore) + maxScore)
            Button(onClick = menuClick) {
                Text(text = stringResource(R.string.menu))
            }
            Button(onClick = playAgainClick) {
                Text(text = stringResource(R.string.play_again))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPrevScreen() {
    WhacAMoleTheme {
        ResultScreenContent(menuClick = {}, playAgainClick = {}, score = 0, maxScore = 0)
    }
}