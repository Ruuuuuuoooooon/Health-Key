package com.example.healthkey.presentation.doctor

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ChatUiState(
    val messages: List<Message> = emptyList(),
    val input: String = "",
    val isTyping: Boolean = false,
    val error: String? = null,
)

class ChatViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    // TODO: inject DoctorRepository, load conversation, handle send
}
