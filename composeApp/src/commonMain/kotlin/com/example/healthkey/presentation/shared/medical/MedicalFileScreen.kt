package com.example.healthkey.presentation.shared.medical

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class MedicalFileScreen(private val patientId: String = "") : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { MedicalViewModel() }
        // TODO: implement medical file UI
    }
}
