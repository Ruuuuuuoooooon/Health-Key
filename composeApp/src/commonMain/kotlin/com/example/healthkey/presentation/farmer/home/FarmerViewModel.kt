package com.example.healthkey.presentation.farmer.home

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class FarmerUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)

class FarmerViewModel : ScreenModel {
    private val _uiState = MutableStateFlow(FarmerUiState())
    val uiState: StateFlow<FarmerUiState> = _uiState.asStateFlow()
}
