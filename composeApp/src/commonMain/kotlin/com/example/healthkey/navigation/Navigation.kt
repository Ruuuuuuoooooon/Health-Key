package com.example.healthkey.navigation

import com.example.healthkey.data.model.UserRole

fun UserRole.defaultScreen(name: String): Screen = when (this) {
    UserRole.FARMER   -> Screen.FarmerHome(name.ifBlank { "Ali" })
    UserRole.DOCTOR   -> Screen.DoctorHome(name.ifBlank { "Dr. Mansour" })
    UserRole.CONSUMER -> Screen.ConsumerHome(name.ifBlank { "Sana" })
    UserRole.ATHLETE  -> Screen.AthleteHome(name.ifBlank { "Yassine" })
    UserRole.PATIENT  -> Screen.MedicalFile
}
