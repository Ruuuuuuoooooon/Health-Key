package com.example.healthkey

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform