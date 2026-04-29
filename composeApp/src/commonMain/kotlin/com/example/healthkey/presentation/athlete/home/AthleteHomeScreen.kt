package com.example.healthkey.presentation.athlete.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class AthleteHomeScreen(private val userName: String = "Yassine") : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { AthleteViewModel() }
        // TODO: implement athlete home UI
    }
}
