package com.example.healthkey.data.model

data class Conversation(
    val id: String,
    val patientId: String,
    val messages: List<Message> = emptyList(),
)
