package com.example.healthkey.presentation.shared

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.Patient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ProfileUiState(
    val patient: Patient? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    // TODO: inject DoctorRepository / AuthRepository and load patient details
}
