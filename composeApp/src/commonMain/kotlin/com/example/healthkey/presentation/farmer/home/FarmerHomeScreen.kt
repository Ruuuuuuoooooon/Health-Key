package com.example.healthkey.presentation.farmer.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class FarmerHomeScreen(private val userName: String = "Ali") : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { FarmerViewModel() }
        // TODO: implement farmer home UI
    }
}
