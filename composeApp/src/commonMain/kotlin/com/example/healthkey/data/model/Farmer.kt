package com.example.healthkey.data.model

data class Farmer(
    val id: String,
    val name: String,
    val region: String,
    val crop: String,
    val method: String,
    val yieldTons: Float,
    val chemicalRisk: String,
    val certifiedOrganic: Boolean,
    val stockKg: Float,
    val pricePerKg: Float,
)

data class Crop(
    val id: String,
    val name: String,
    val progressPct: Int,
    val season: String,
    val areaHa: Float,
    val daysUntilHarvest: Int,
)

data class ClimateSnapshot(
    val tempCelsius: Float,
    val humidityPct: Int,
    val droughtRisk: String,
    val rainfallMm: Float,
)

data class RecommendedCrop(
    val name: String,
    val demandLevel: DemandLevel,
    val reason: String,
)

enum class DemandLevel(val label: String) {
    HIGH("High Demand"),
    MEDIUM("Medium Demand"),
    LOW("Low Demand"),
}
