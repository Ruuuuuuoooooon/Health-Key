package com.example.healthkey.presentation.consumer.nutriguide

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class NutriGuideScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { NutriGuideViewModel() }
        // TODO: implement NutriGuide UI
    }
}
