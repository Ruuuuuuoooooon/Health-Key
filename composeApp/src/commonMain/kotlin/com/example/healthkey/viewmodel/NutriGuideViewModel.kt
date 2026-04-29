package com.example.healthkey.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import com.example.healthkey.data.NutriGuideEngine
import com.example.healthkey.data.model.ChatMessage
import com.example.healthkey.data.model.NutriProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

data class NutriGuideState(
    val messages: List<ChatMessage> = listOf(
        ChatMessage(
            id = "0",
            senderName = "NutriGuide",
            content = "Hello! I'm NutriGuide, your Tunisian nutrition assistant. Ask me about your diet, healthy foods, or wellness tips!",
            timestamp = "now",
            isFromUser = false
        )
    ),
    val input: String = "",
    val isTyping: Boolean = false,
)

class NutriGuideViewModel : ScreenModel {
    private val _state = MutableStateFlow(NutriGuideState())
    val state: StateFlow<NutriGuideState> = _state.asStateFlow()

    fun onInputChange(v: String) = _state.update { it.copy(input = v) }

    fun sendMessage(question: String, profile: NutriProfile) {
        val text = question.trim()
        if (text.isBlank()) return

        val userMsg = ChatMessage(
            id = Random.nextLong().toString(),
            senderName = "Me",
            content = text,
            timestamp = "now",
            isFromUser = true,
        )

        val botResponse = NutriGuideEngine.getResponse(text, profile)
        val botMsg = ChatMessage(
            id = Random.nextLong().toString(),
            senderName = "NutriGuide",
            content = botResponse,
            timestamp = "now",
            isFromUser = false,
        )

        _state.update { 
            it.copy(
                messages = it.messages + userMsg + botMsg,
                input = ""
            ) 
        }
    }
}
