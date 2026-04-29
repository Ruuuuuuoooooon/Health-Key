package com.example.healthkey.presentation.doctor

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.Patient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class PatientsUiState(
    val patients: List<Patient> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)

class PatientsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PatientsUiState())
    val uiState: StateFlow<PatientsUiState> = _uiState.asStateFlow()

    // TODO: inject DoctorRepository, load + filter patients
}
