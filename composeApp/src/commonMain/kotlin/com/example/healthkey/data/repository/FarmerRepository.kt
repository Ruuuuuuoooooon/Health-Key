package com.example.healthkey.data.repository

import com.example.healthkey.data.model.ClimateSnapshot
import com.example.healthkey.data.model.Crop
import com.example.healthkey.data.model.RecommendedCrop

interface FarmerRepository {
    suspend fun getCrops(farmerId: String): Result<List<Crop>>
    suspend fun getClimateSnapshot(): Result<ClimateSnapshot>
    suspend fun getRecommendedCrops(): Result<List<RecommendedCrop>>
}
