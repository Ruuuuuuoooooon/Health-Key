package com.example.healthkey.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.healthkey.data.model.Farmer
import com.example.healthkey.data.repository.FirestoreRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FarmerViewModel(private val firestoreRepository: FirestoreRepository) : ScreenModel {
    private val _farmers = MutableStateFlow<List<Farmer>>(emptyList())
    val farmers: StateFlow<List<Farmer>> = _farmers.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadFarmers()
    }

    fun loadFarmers() {
        screenModelScope.launch {
            _isLoading.value = true
            _farmers.value = firestoreRepository.getFarmers()
            _isLoading.value = false
        }
    }
}
