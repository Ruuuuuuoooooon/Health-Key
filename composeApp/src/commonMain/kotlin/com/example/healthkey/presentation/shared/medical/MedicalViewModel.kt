package com.example.healthkey.presentation.shared.medical

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MedicalUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)

class MedicalViewModel : ScreenModel {
    private val _uiState = MutableStateFlow(MedicalUiState())
    val uiState: StateFlow<MedicalUiState> = _uiState.asStateFlow()
}
