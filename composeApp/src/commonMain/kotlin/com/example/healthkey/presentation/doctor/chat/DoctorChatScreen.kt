package com.example.healthkey.presentation.doctor.chat

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class DoctorChatScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { ChatViewModel() }
        // TODO: implement doctor chat UI
    }
}
