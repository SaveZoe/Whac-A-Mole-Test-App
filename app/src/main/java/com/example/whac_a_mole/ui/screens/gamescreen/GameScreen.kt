package com.example.whac_a_mole.ui.screens.gamescreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.whac_a_mole.R
import com.example.whac_a_mole.navigation.NavRoute
import com.example.whac_a_mole.ui.screens.gamescreen.models.GameEvent
import com.example.whac_a_mole.ui.screens.gamescreen.models.GameState
import com.example.whac_a_mole.ui.theme.WhacAMoleTheme
import kotlinx.coroutines.delay

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel = viewModel()) {

    val viewState = viewModel.viewState.collectAsState(GameState())

    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(1 * 1000)
            if (viewModel.timer.value == 0) {
                navController.popBackStack()
                navController.navigate(NavRoute.ResultScreen.name)
                viewModel.saveResult(viewState.value.score)
                Log.d("test", "GameScreen: ${viewState.value.score}")
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.timer()
        while (true) {
            delay(1000)
            Log.d(
                "test",
                "GameScreen: viewState.value.totalSeconds"
            )
        }
    }
    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(500)
            viewModel.random()
            delay(499)
            viewModel.startState()
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        PlayingField(
            onclick = {
                viewModel.render(GameEvent.ScoreChanged(it))
                Log.d("test", "GameScreen: ${GameState().score}")
            },
            viewState = viewState.value
        )
    }
}

@Composable
fun PlayingField(
    viewState: GameState,
    onclick: (Int) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Green)
    )
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Text(text = "Timer ${viewState.totalSeconds}")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(
                onClick = {
                    if (viewState.seeMole1) {
                        onclick.invoke(viewState.score + 1)
                    }
                },
                modifier = Modifier.testTag("test")
            ) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole1) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
            IconButton(onClick = {
                if (viewState.seeMole2) {
                    onclick.invoke(viewState.score + 1)
                }
            }) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole2) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
            IconButton(onClick = {
                if (viewState.seeMole3) {
                    onclick.invoke(viewState.score + 1)
                }
            }) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole3) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = {
                if (viewState.seeMole4) {
                    onclick.invoke(viewState.score + 1)
                }
            }) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole4) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
            IconButton(onClick = {
                if (viewState.seeMole5) {
                    onclick.invoke(viewState.score + 1)
                }
            }) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole5) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
            IconButton(onClick = {
                if (viewState.seeMole6) {
                    onclick.invoke(viewState.score + 1)
                }
            }) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole6) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = {
                if (viewState.seeMole7) {
                    onclick.invoke(viewState.score + 1)
                }
            }) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole7) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
            IconButton(onClick = {
                if (viewState.seeMole8) {
                    onclick.invoke(viewState.score + 1)
                }
            }) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole8) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
            IconButton(onClick = {
                if (viewState.seeMole9) {
                    onclick.invoke(viewState.score + 1)
                }
            }) {
                Image(painter = painterResource(id = R.drawable.molehill), contentDescription = null)
                if (viewState.seeMole9) {
                    Image(
                        painter = painterResource(id = R.drawable.mole),
                        contentDescription = null,
                        modifier = Modifier.size(72.dp)
                    )
                }
            }
        }
        Text(text = stringResource(R.string.Score) + viewState.score)
    }
}

@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 720, heightDp = 360)
@Composable
fun PrevGameScreen() {
    WhacAMoleTheme {
        PlayingField(
            onclick = {

            },
            viewState = GameState()
        )
    }
}