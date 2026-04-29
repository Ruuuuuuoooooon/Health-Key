package com.example.healthkey.presentation.farmer.earth2

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class Earth2Screen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { Earth2ViewModel() }
        // TODO: implement Earth 2 UI
    }
}
