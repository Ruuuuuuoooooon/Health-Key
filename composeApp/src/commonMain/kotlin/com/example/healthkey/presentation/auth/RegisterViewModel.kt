package com.example.healthkey.presentation.auth

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.UserRole
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RegisterUiState(
    val step: Int = 0,                  // 0 = Role, 1 = Info, 2 = Done
    val selectedRole: UserRole? = null,
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    // TODO: inject AuthRepository and implement step-by-step registration
}
