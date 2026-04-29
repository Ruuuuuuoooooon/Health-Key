package com.example.healthkey.presentation.farmer

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.ClimateSnapshot
import com.example.healthkey.data.model.RecommendedCrop
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Earth2UiState(
    val climate: ClimateSnapshot? = null,
    val recommendedCrops: List<RecommendedCrop> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

class Earth2ViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(Earth2UiState())
    val uiState: StateFlow<Earth2UiState> = _uiState.asStateFlow()

    // TODO: inject FarmerRepository and load climate + crop recommendations
}
