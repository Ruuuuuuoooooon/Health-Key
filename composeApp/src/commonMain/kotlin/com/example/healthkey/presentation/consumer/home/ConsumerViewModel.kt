package com.example.healthkey.presentation.consumer.home

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ConsumerUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)

class ConsumerViewModel : ScreenModel {
    private val _uiState = MutableStateFlow(ConsumerUiState())
    val uiState: StateFlow<ConsumerUiState> = _uiState.asStateFlow()
}
