package com.example.healthkey.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.example.healthkey.presentation.athlete.AthleteHomeScreen
import com.example.healthkey.presentation.athlete.WellnessPlanScreen
import com.example.healthkey.presentation.auth.LoginScreen
import com.example.healthkey.presentation.auth.RegisterScreen
import com.example.healthkey.presentation.consumer.ConsumerHomeScreen
import com.example.healthkey.presentation.consumer.NutriGuideScreen
import com.example.healthkey.presentation.consumer.ProductsScreen
import com.example.healthkey.presentation.doctor.ChatScreen
import com.example.healthkey.presentation.doctor.DoctorHomeScreen
import com.example.healthkey.presentation.doctor.PatientsScreen
import com.example.healthkey.presentation.farmer.Earth2Screen
import com.example.healthkey.presentation.farmer.FarmerHomeScreen
import com.example.healthkey.presentation.shared.MedicalFileScreen
import com.example.healthkey.presentation.shared.ProfileScreen
import cafe.adriel.voyager.core.screen.Screen as VoyagerScreen

@Composable
fun AppNavigation() {
    Navigator(screen = LoginScreen())
}

fun Screen.toVoyagerScreen(): VoyagerScreen = when (this) {
    is Screen.Login -> LoginScreen()
    is Screen.Register -> RegisterScreen()
    is Screen.FarmerHome -> FarmerHomeScreen(userName)
    is Screen.FarmerEarth2 -> Earth2Screen()
    is Screen.DoctorHome -> DoctorHomeScreen(userName)
    is Screen.DoctorPatients -> PatientsScreen()
    is Screen.DoctorChat -> ChatScreen()
    is Screen.ConsumerHome -> ConsumerHomeScreen(userName)
    is Screen.ConsumerProducts -> ProductsScreen()
    is Screen.NutriGuide -> NutriGuideScreen()
    is Screen.Profile -> ProfileScreen(userName)
    is Screen.MedicalFile -> MedicalFileScreen()
    is Screen.AthleteHome -> AthleteHomeScreen(userName)
    is Screen.WellnessPlan -> WellnessPlanScreen()
}
