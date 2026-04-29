package com.example.healthkey.presentation.auth.register

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class RegisterScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { RegisterViewModel() }
        // TODO: implement register UI
    }
}
