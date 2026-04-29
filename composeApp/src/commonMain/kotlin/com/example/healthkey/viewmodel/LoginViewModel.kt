package com.example.healthkey.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.healthkey.data.model.UserRole
import com.example.healthkey.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoginState(
    val selectedRole: UserRole? = null,
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)

class LoginViewModel(private val authRepository: AuthRepository) : ScreenModel {
    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun selectRole(role: UserRole) = _state.update { it.copy(selectedRole = role, error = null) }
    fun onEmailChange(v: String) = _state.update { it.copy(email = v, error = null) }
    fun onPasswordChange(v: String) = _state.update { it.copy(password = v, error = null) }

    fun signIn(onSuccess: (UserRole) -> Unit) {
        val s = _state.value
        if (s.selectedRole == null) {
            _state.update { it.copy(error = "Please select a role") }
            return
        }
        if (s.email.isBlank() || s.password.isBlank()) {
            _state.update { it.copy(error = "Please fill all fields") }
            return
        }

        screenModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            val result = authRepository.signIn(s.email, s.password)
            result.onSuccess { user ->
                _state.update { it.copy(isLoading = false) }
                onSuccess(user.role)
            }.onFailure { error ->
                _state.update { it.copy(isLoading = false, error = error.message ?: "Sign in failed") }
            }
        }
    }
}
