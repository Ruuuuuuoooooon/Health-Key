package com.example.healthkey.presentation.shared

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class ProfileScreen(private val userName: String = "Sana Ben Ali") : Screen {
    @Composable
    override fun Content() {
        // TODO: implement patient profile UI
        //  - blue header (#1565C0) with avatar initials circle
        //  - patient info rows (age, condition, doctor, diet, allergies, last visit)
        //  - status tag
        //  - navigate to MedicalFileScreen / ChatScreen
    }
}
