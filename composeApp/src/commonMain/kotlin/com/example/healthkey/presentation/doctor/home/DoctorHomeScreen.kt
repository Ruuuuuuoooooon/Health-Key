package com.example.healthkey.presentation.doctor.home

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class DoctorHomeScreen(private val userName: String = "Dr. Mansour") : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { DoctorViewModel() }
        // TODO: implement doctor home UI
    }
}
