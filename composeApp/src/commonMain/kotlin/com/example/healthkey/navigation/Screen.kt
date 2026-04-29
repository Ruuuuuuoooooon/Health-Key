package com.example.healthkey.navigation

sealed class Screen {
    data object Login : Screen()
    data object Register : Screen()
    data class FarmerHome(val userName: String = "Ali") : Screen()
    data object FarmerEarth2 : Screen()
    data class DoctorHome(val userName: String = "Dr. Mansour") : Screen()
    data object DoctorPatients : Screen()
    data object DoctorChat : Screen()
    data class ConsumerHome(val userName: String = "Sana") : Screen()
    data object ConsumerProducts : Screen()
    data object NutriGuide : Screen()
    data class Profile(val userName: String = "Sana Ben Ali") : Screen()
    data object MedicalFile : Screen()
    data class AthleteHome(val userName: String = "Yassine") : Screen()
    data object WellnessPlan : Screen()
}
