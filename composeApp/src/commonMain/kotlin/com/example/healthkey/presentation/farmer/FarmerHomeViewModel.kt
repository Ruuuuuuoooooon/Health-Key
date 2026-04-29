package com.example.healthkey.presentation.farmer

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.Crop
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class FarmerHomeUiState(
    val crops: List<Crop> = emptyList(),
    val activeCropCount: Int = 0,
    val totalAreaHa: Float = 0f,
    val marketPriceEur: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null,
)

class FarmerHomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FarmerHomeUiState())
    val uiState: StateFlow<FarmerHomeUiState> = _uiState.asStateFlow()

    // TODO: inject FarmerRepository and load crops
}
