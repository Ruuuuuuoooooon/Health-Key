package com.example.healthkey.data.repository

import com.example.healthkey.data.model.User
import com.example.healthkey.data.model.UserRole

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Result<User>
    suspend fun register(
        name: String,
        email: String,
        password: String,
        role: UserRole,
    ): Result<User>
    suspend fun signOut()
    fun currentUser(): User?
}
