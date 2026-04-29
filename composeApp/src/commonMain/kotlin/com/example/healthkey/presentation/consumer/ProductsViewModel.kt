package com.example.healthkey.presentation.consumer

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ProductsUiState(
    val products: List<Product> = emptyList(),
    val scannedProduct: Product? = null,
    val isScanning: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
)

class ProductsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProductsUiState())
    val uiState: StateFlow<ProductsUiState> = _uiState.asStateFlow()

    // TODO: inject ConsumerRepository, handle QR scan and product lookup
}
