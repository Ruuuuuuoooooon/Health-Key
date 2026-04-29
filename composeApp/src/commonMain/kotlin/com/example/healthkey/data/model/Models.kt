package com.example.healthkey.data.model

enum class NutriProfile(val label: String) {
    ATHLETE("Athlete"),
    DIABETIC("Diabetic"),
    PREGNANT("Pregnant"),
    ELDERLY("Elderly"),
    GENERAL("General"),
}

data class CropCard(
    val name: String,
    val progress: Int,
    val season: String,
    val area: String,
    val daysLeft: Int,
)

data class ClimateData(
    val tempC: Float,
    val humidityPct: Int,
    val droughtRisk: String,
    val rainfallMm: Float,
)

data class NavItem(val label: String, val icon: NavIcon)

enum class NavIcon { HOME, CROPS, MARKET, EARTH, NUTRITION, DISCOVER, PROFILE_NAV }

object SampleData {
    val crops = listOf(
        CropCard("Tomatoes", 72, "Spring", "2.4 ha", 18),
        CropCard("Wheat", 45, "Winter", "5.1 ha", 42),
        CropCard("Olives", 88, "Autumn", "3.8 ha", 7),
        CropCard("Peppers", 30, "Spring", "1.2 ha", 60),
    )

    val meals = listOf(
        MealItem(
            "Slata Mechouia + Egg",
            "7:00 AM",
            380,
            MealStatus.DONE,
            "Grilled salad, boiled egg, whole wheat bread",
        ),
        MealItem(
            "Couscous with Vegetables",
            "1:00 PM",
            620,
            MealStatus.NEXT,
            "Steamed couscous, seasonal vegetables, harissa on the side",
        ),
        MealItem(
            "Lablabi Soup",
            "7:30 PM",
            420,
            MealStatus.UPCOMING,
            "Chickpea soup with cumin, olive oil, and bread",
        ),
    )

    val recoveryFoods = listOf(
        RecoveryFood("Dates & Almond Mix", "Post-Workout", "8g", "42g", "🌴"),
        RecoveryFood("Grilled Chicken Wrap", "Post-Workout", "36g", "28g", "🌯"),
        RecoveryFood("Bsissa Shake", "Recovery", "12g", "34g", "🥛"),
        RecoveryFood("Assida + Honey", "Recovery", "6g", "58g", "🍯"),
    )

    val climate = ClimateData(28.4f, 62, "Moderate", 4.2f)

    val recommendedCrops = listOf(
        RecommendedCrop("Tomatoes", DemandLevel.HIGH, "High export demand, suitable soil moisture"),
        RecommendedCrop("Harissa Peppers", DemandLevel.HIGH, "National staple, strong market price"),
        RecommendedCrop("Durum Wheat", DemandLevel.MEDIUM, "Government subsidy program active"),
        RecommendedCrop("Olive Oil Grade A", DemandLevel.HIGH, "EU export season begins"),
        RecommendedCrop("Melon", DemandLevel.MEDIUM, "Summer market approaching"),
    )

    val farmerNavItems = listOf(
        NavItem(label = "Home", icon = NavIcon.HOME),
        NavItem(label = "Crops", icon = NavIcon.CROPS),
        NavItem(label = "Market", icon = NavIcon.MARKET),
        NavItem(label = "Earth 2", icon = NavIcon.EARTH),
    )

    val athleteNavItems = listOf(
        NavItem(label = "Home", icon = NavIcon.HOME),
        NavItem(label = "Nutrition", icon = NavIcon.NUTRITION),
        NavItem(label = "Discover", icon = NavIcon.DISCOVER),
        NavItem(label = "Profile", icon = NavIcon.PROFILE_NAV),
    )
}
