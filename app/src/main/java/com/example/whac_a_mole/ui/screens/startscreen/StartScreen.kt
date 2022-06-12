package com.example.whac_a_mole.ui.screens.startscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.whac_a_mole.R
import com.example.whac_a_mole.navigation.NavRoute
import com.example.whac_a_mole.ui.theme.WhacAMoleTheme

@Composable
fun StartScreen(navController: NavController, viewModel: StartViewModel = viewModel()) {
    val score = viewModel.score.collectAsState(0).value
    StartScreenContent(
        score = score,
        onclick = { navController.navigate(NavRoute.GameScreen.name) })
}

@Composable
fun StartScreenContent(
    score: Int,
    onclick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.start),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Whack A Mole",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.Rules))
            Button(onClick = onclick) {
                Text(text = stringResource(R.string.Play))
            }
            Text(text = stringResource(R.string.YourScore) + score)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevStartScreen() {
    WhacAMoleTheme {
        StartScreenContent(0, onclick = {})
    }
}

