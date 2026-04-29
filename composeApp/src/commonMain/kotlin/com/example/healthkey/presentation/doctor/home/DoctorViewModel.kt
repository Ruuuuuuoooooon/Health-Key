package com.example.healthkey.presentation.doctor.home

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DoctorUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)

class DoctorViewModel : ScreenModel {
    private val _uiState = MutableStateFlow(DoctorUiState())
    val uiState: StateFlow<DoctorUiState> = _uiState.asStateFlow()
}
