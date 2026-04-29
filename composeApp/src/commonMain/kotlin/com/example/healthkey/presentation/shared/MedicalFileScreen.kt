package com.example.healthkey.presentation.shared

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class MedicalFileScreen(private val patientId: String = "") : Screen {
    @Composable
    override fun Content() {
        // TODO: implement medical file UI
        //  - blue header with back button
        //  - SectionCard for Diagnosis (colored cards + status tags)
        //  - SectionCard for Allergies
        //  - SectionCard for Diet & Prescriptions
    }
}
