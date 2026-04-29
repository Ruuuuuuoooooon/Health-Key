package com.example.healthkey.domain.usecase

// Marker interface implemented by every use case.
// Params  — input type; use NoParams when no input is needed.
// Returns — output type, typically Result<T>.
interface UseCase<in Params, out Returns> {
    suspend operator fun invoke(params: Params): Returns
}

object NoParams
