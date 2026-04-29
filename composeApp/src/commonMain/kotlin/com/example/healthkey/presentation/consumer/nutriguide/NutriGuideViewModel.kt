package com.example.healthkey.presentation.consumer.nutriguide

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class NutriGuideUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)

class NutriGuideViewModel : ScreenModel {
    private val _uiState = MutableStateFlow(NutriGuideUiState())
    val uiState: StateFlow<NutriGuideUiState> = _uiState.asStateFlow()
}
