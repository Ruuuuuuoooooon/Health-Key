package com.example.healthkey.data.model

data class Product(
    val id: String,
    val farmerId: String,
    val name: String,
    val region: String,
    val method: String,
    val nutritionalTag: String,
    val recommendedFor: String,
    val chemicalRisk: String,
    val stockKg: Float,
    val price: Float,
    val organic: Boolean,
)

data class NutriProfileData(
    val type: NutriProfileType,
    val dailyCalorieGoal: Int,
    val proteinGrams: Int,
    val carbsGrams: Int,
    val fatGrams: Int,
)

enum class NutriProfileType(val label: String) {
    ATHLETE("Athlete"),
    DIABETIC("Diabetic"),
    PREGNANT("Pregnant"),
    ELDERLY("Elderly"),
    GENERAL("General"),
}

data class MealItem(
    val name: String,
    val time: String,
    val calories: Int,
    val status: MealStatus,
    val description: String,
)

enum class MealStatus { DONE, NEXT, UPCOMING }

data class RecoveryFood(
    val name: String,
    val tag: String,
    val proteinGrams: String,
    val carbsGrams: String,
    val emoji: String,
)
