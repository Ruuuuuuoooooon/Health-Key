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

data class RegisterState(
    val step: Int = 1, // 1=Role, 2=Info, 3=Credentials
    val selectedRole: UserRole? = null,
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)

class RegisterViewModel(private val authRepository: AuthRepository) : ScreenModel {
    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state.asStateFlow()

    fun selectRole(role: UserRole) = _state.update { it.copy(selectedRole = role, error = null) }
    fun onNameChange(v: String) = _state.update { it.copy(fullName = v, error = null) }
    fun onEmailChange(v: String) = _state.update { it.copy(email = v, error = null) }
    fun onPasswordChange(v: String) = _state.update { it.copy(password = v, error = null) }

    fun next() {
        val s = _state.value
        when (s.step) {
            1 -> {
                if (s.selectedRole == null) {
                    _state.update { it.copy(error = "Please select a role") }
                } else {
                    _state.update { it.copy(step = 2, error = null) }
                }
            }
            2 -> {
                if (s.fullName.isBlank()) {
                    _state.update { it.copy(error = "Please enter your name") }
                } else {
                    _state.update { it.copy(step = 3, error = null) }
                }
            }
        }
    }

    fun back() {
        if (_state.value.step > 1) {
            _state.update { it.copy(step = it.step - 1, error = null) }
        }
    }

    fun register(onSuccess: (UserRole) -> Unit) {
        val s = _state.value
        if (s.email.isBlank() || s.password.isBlank()) {
            _state.update { it.copy(error = "Please fill all fields") }
            return
        }

        screenModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            val result = authRepository.register(
                name = s.fullName,
                email = s.email,
                password = s.password,
                role = s.selectedRole ?: UserRole.CONSUMER
            )
            result.onSuccess { user ->
                _state.update { it.copy(isLoading = false) }
                onSuccess(user.role)
            }.onFailure { error ->
                _state.update { it.copy(isLoading = false, error = error.message ?: "Registration failed") }
            }
        }
    }
}
