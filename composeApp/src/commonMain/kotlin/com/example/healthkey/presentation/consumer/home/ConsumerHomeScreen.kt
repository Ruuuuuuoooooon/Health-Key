package com.example.healthkey.presentation.consumer.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class ConsumerHomeScreen(private val userName: String = "Sana") : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { ConsumerViewModel() }
        // TODO: implement consumer home UI
    }
}
