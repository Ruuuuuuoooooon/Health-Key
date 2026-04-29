package com.example.healthkey.presentation.consumer

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ConsumerHomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)

class ConsumerHomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ConsumerHomeUiState())
    val uiState: StateFlow<ConsumerHomeUiState> = _uiState.asStateFlow()

    // TODO: inject ConsumerRepository
}
