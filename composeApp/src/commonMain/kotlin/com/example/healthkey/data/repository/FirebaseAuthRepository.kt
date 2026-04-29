package com.example.healthkey.data.repository

import com.example.healthkey.data.model.User
import com.example.healthkey.data.model.UserRole
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

@Serializable
private data class UserDto(
    val name: String = "",
    val email: String = "",
    val role: String = "",
)

class FirebaseAuthRepository : AuthRepository {
    private val auth = Firebase.auth
    private val db = Firebase.firestore
    private var cachedUser: User? = null

    override suspend fun signIn(email: String, password: String): Result<User> = try {
        val result = auth.signInWithEmailAndPassword(email, password)
        val uid = result.user?.uid ?: return Result.failure(Exception("Authentication failed"))
        val doc = db.collection("users").document(uid).get()
        if (!doc.exists) return Result.failure(Exception("User profile not found"))
        val dto = doc.data<UserDto>()
        val user = User(
            id = uid,
            name = dto.name,
            email = dto.email,
            role = runCatching { UserRole.valueOf(dto.role) }.getOrDefault(UserRole.CONSUMER),
        )
        cachedUser = user
        Result.success(user)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        role: UserRole,
    ): Result<User> = try {
        val result = auth.createUserWithEmailAndPassword(email, password)
        val uid = result.user?.uid ?: return Result.failure(Exception("Registration failed"))
        db.collection("users").document(uid).set(UserDto(name = name, email = email, role = role.name))
        val user = User(id = uid, name = name, email = email, role = role)
        cachedUser = user
        Result.success(user)
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun signOut() {
        auth.signOut()
        cachedUser = null
    }

    // Non-suspend: returns in-memory cache only. Call signIn() after cold start to rehydrate.
    override fun currentUser(): User? = cachedUser
}
