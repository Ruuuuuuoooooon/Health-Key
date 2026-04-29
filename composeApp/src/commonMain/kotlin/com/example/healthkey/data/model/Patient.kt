package com.example.healthkey.data.model

data class Patient(
    val id: String,
    val name: String,
    val age: Int,
    val condition: String,
    val doctorName: String,
    val dietPlan: String,
    val allergies: String,
    val lastVisit: String,
    val notes: String,
    val profile: NutriProfile,
)

enum class PatientStatus(val label: String) {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    CRITICAL("Critical"),
}
