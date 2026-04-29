package com.example.healthkey.presentation.doctor

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.Patient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DoctorHomeUiState(
    val patients: List<Patient> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

class DoctorHomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DoctorHomeUiState())
    val uiState: StateFlow<DoctorHomeUiState> = _uiState.asStateFlow()

    // TODO: inject DoctorRepository and load patient list
}
