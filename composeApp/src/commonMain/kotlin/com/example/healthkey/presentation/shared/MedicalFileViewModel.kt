package com.example.healthkey.presentation.shared

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.Patient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MedicalFileUiState(
    val patient: Patient? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)

class MedicalFileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MedicalFileUiState())
    val uiState: StateFlow<MedicalFileUiState> = _uiState.asStateFlow()

    // TODO: inject DoctorRepository and load patient medical data
}
