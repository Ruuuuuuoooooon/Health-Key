package com.example.healthkey.data.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val role: UserRole,
)

enum class UserRole(val label: String, val emoji: String) {
    FARMER("Farmer", "🌾"),
    DOCTOR("Doctor", "🩺"),
    CONSUMER("Consumer", "🛒"),
    ATHLETE("Athlete", "🏃"),
    PATIENT("Patient", "🏥"),
}
