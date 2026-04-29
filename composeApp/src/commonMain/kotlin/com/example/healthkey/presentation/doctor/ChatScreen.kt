package com.example.healthkey.presentation.doctor

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class ChatScreen(private val conversationId: String = "") : Screen {
    @Composable
    override fun Content() {
        // TODO: implement doctor–patient chat UI
        //  - blue header (#1565C0) with doctor name and online indicator
        //  - chat bubbles (them: light blue, me: #1565C0)
        //  - message input bar with send button
    }
}
