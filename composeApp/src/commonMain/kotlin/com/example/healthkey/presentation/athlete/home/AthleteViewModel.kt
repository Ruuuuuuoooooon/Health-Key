package com.example.healthkey.presentation.athlete.home

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AthleteUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)

class AthleteViewModel : ScreenModel {
    private val _uiState = MutableStateFlow(AthleteUiState())
    val uiState: StateFlow<AthleteUiState> = _uiState.asStateFlow()
}
