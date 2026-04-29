package com.example.healthkey.presentation.auth

import androidx.lifecycle.ViewModel
import com.example.healthkey.data.model.UserRole
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val selectedRole: UserRole? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    // TODO: inject AuthRepository and implement sign-in
}
