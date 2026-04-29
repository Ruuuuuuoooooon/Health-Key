package com.example.healthkey.data.model

data class ChatMessage(
    val id: String,
    val senderName: String,
    val content: String,
    val timestamp: String,
    val isFromUser: Boolean,
)
