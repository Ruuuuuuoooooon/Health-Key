package com.example.healthkey.presentation.consumer

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.Message
import com.example.healthkey.data.model.NutriProfileType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class NutriGuideUiState(
    val messages: List<Message> = emptyList(),
    val input: String = "",
    val profile: NutriProfileType = NutriProfileType.GENERAL,
    val isTyping: Boolean = false,
    val error: String? = null,
)

class NutriGuideViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(NutriGuideUiState())
    val uiState: StateFlow<NutriGuideUiState> = _uiState.asStateFlow()

    // TODO: inject ConsumerRepository and rule-based NutriGuide engine
}
