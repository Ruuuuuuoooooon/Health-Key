package com.example.healthkey.data.repository

import com.example.healthkey.data.model.Message
import com.example.healthkey.data.model.NutriProfileType
import com.example.healthkey.data.model.Product

interface ConsumerRepository {
    suspend fun getProducts(): Result<List<Product>>
    suspend fun scanProduct(qrCode: String): Result<Product>
    suspend fun sendNutriGuideMessage(
        text: String,
        profile: NutriProfileType,
    ): Result<Message>
}
