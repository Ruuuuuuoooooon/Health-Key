package com.example.healthkey.presentation.farmer.earth2

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Earth2UiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)

class Earth2ViewModel : ScreenModel {
    private val _uiState = MutableStateFlow(Earth2UiState())
    val uiState: StateFlow<Earth2UiState> = _uiState.asStateFlow()
}
