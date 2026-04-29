package com.example.healthkey.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.healthkey.data.model.Patient
import com.example.healthkey.data.repository.FirestoreRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class DoctorState(
    val patients: List<Patient> = emptyList(),
    val selectedPatient: Patient? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class DoctorViewModel(private val firestoreRepository: FirestoreRepository) : ScreenModel {
    private val _state = MutableStateFlow(DoctorState())
    val state: StateFlow<DoctorState> = _state.asStateFlow()

    init {
        loadPatients()
    }

    fun loadPatients() {
        screenModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val patients = firestoreRepository.getPatients()
                _state.value = _state.value.copy(patients = patients, isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message, isLoading = false)
            }
        }
    }

    fun selectPatient(patient: Patient) {
        _state.value = _state.value.copy(selectedPatient = patient)
    }

    fun clearSelectedPatient() {
        _state.value = _state.value.copy(selectedPatient = null)
    }
}
