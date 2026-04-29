package com.example.healthkey.core.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.example.healthkey.presentation.auth.LoginScreen

// ─── Route index ────────────────────────────────────────────────────────────
//
// Each entry is a Voyager Screen defined in its own presentation package.
// Navigate to a new screen via:  navigator.push(TargetScreen())
// Go back:                        navigator.pop()
//
// Auth
//   LoginScreen          — presentation/auth/LoginScreen.kt
//   RegisterScreen       — presentation/auth/RegisterScreen.kt
//
// Farmer
//   FarmerHomeScreen     — presentation/farmer/FarmerHomeScreen.kt
//   Earth2Screen         — presentation/farmer/Earth2Screen.kt
//
// Doctor
//   DoctorHomeScreen     — presentation/doctor/DoctorHomeScreen.kt
//   PatientsScreen       — presentation/doctor/PatientsScreen.kt
//   ChatScreen           — presentation/doctor/ChatScreen.kt
//
// Consumer
//   ConsumerHomeScreen   — presentation/consumer/ConsumerHomeScreen.kt
//   ProductsScreen       — presentation/consumer/ProductsScreen.kt
//   NutriGuideScreen     — presentation/consumer/NutriGuideScreen.kt
//
// Shared
//   ProfileScreen        — presentation/shared/ProfileScreen.kt
//   MedicalFileScreen    — presentation/shared/MedicalFileScreen.kt
// ────────────────────────────────────────────────────────────────────────────

@Composable
fun AppNavigation() {
    Navigator(screen = LoginScreen())
}
