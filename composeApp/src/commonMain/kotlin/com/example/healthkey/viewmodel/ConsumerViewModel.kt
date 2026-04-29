package com.example.healthkey.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.healthkey.data.model.Product
import com.example.healthkey.data.repository.FirestoreRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ConsumerState(
    val products: List<Product> = emptyList(),
    val filteredProducts: List<Product> = emptyList(),
    val selectedCondition: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class ConsumerViewModel(private val firestoreRepository: FirestoreRepository) : ScreenModel {
    private val _state = MutableStateFlow(ConsumerState())
    val state: StateFlow<ConsumerState> = _state.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        screenModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val products = firestoreRepository.getProducts()
                _state.value = _state.value.copy(
                    products = products,
                    filteredProducts = products,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message, isLoading = false)
            }
        }
    }

    fun filterByCondition(condition: String?) {
        val allProducts = _state.value.products
        val filtered = if (condition.isNullOrBlank()) {
            allProducts
        } else {
            allProducts.filter { it.recommendedFor.contains(condition, ignoreCase = true) }
        }
        _state.value = _state.value.copy(
            selectedCondition = condition,
            filteredProducts = filtered
        )
    }
}
