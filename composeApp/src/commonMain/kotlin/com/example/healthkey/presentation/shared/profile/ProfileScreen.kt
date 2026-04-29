package com.example.healthkey.presentation.shared.profile

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class ProfileScreen(private val userName: String = "Sana Ben Ali") : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { ProfileViewModel() }
        // TODO: implement profile UI
    }
}
