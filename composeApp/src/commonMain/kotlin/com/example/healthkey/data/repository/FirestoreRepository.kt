package com.example.healthkey.data.repository

import com.example.healthkey.data.model.Farmer
import com.example.healthkey.data.model.NutriProfile
import com.example.healthkey.data.model.Patient
import com.example.healthkey.data.model.Product
import com.example.healthkey.data.model.User
import com.example.healthkey.data.model.UserRole
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.DocumentSnapshot
import dev.gitlive.firebase.firestore.firestore
import kotlinx.serialization.Serializable

@Serializable
private data class FarmerDto(
    val name: String = "",
    val region: String = "",
    val crop: String = "",
    val method: String = "",
    val yieldTons: Double = 0.0,
    val chemicalRisk: String = "",
    val certifiedOrganic: Boolean = false,
    val stockKg: Double = 0.0,
    val pricePerKg: Double = 0.0,
)

@Serializable
private data class ProductDto(
    val farmerId: String = "",
    val name: String = "",
    val region: String = "",
    val method: String = "",
    val nutritionalTag: String = "",
    val recommendedFor: String = "",
    val chemicalRisk: String = "",
    val stockKg: Double = 0.0,
    val price: Double = 0.0,
    val organic: Boolean = false,
)

@Serializable
private data class PatientDto(
    val name: String = "",
    val age: Long = 0,
    val condition: String = "",
    val doctorName: String = "",
    val dietPlan: String = "",
    val allergies: String = "",
    val lastVisit: String = "",
    val notes: String = "",
    val profile: String = NutriProfile.GENERAL.name,
)

@Serializable
private data class UserDocDto(
    val name: String = "",
    val email: String = "",
    val role: String = "",
)

private fun DocumentSnapshot.toFarmer(): Farmer {
    val dto = data<FarmerDto>()
    return Farmer(
        id = id,
        name = dto.name,
        region = dto.region,
        crop = dto.crop,
        method = dto.method,
        yieldTons = dto.yieldTons.toFloat(),
        chemicalRisk = dto.chemicalRisk,
        certifiedOrganic = dto.certifiedOrganic,
        stockKg = dto.stockKg.toFloat(),
        pricePerKg = dto.pricePerKg.toFloat(),
    )
}

private fun DocumentSnapshot.toProduct(): Product {
    val dto = data<ProductDto>()
    return Product(
        id = id,
        farmerId = dto.farmerId,
        name = dto.name,
        region = dto.region,
        method = dto.method,
        nutritionalTag = dto.nutritionalTag,
        recommendedFor = dto.recommendedFor,
        chemicalRisk = dto.chemicalRisk,
        stockKg = dto.stockKg.toFloat(),
        price = dto.price.toFloat(),
        organic = dto.organic,
    )
}

private fun DocumentSnapshot.toPatient(): Patient {
    val dto = data<PatientDto>()
    return Patient(
        id = id,
        name = dto.name,
        age = dto.age.toInt(),
        condition = dto.condition,
        doctorName = dto.doctorName,
        dietPlan = dto.dietPlan,
        allergies = dto.allergies,
        lastVisit = dto.lastVisit,
        notes = dto.notes,
        profile = runCatching { NutriProfile.valueOf(dto.profile) }.getOrDefault(NutriProfile.GENERAL),
    )
}

private fun DocumentSnapshot.toUser(): User {
    val dto = data<UserDocDto>()
    return User(
        id = id,
        name = dto.name,
        email = dto.email,
        role = runCatching { UserRole.valueOf(dto.role) }.getOrDefault(UserRole.CONSUMER),
    )
}

class FirestoreRepository {
    private val db = Firebase.firestore

    suspend fun getFarmers(): List<Farmer> = try {
        db.collection("farmers").get().documents.map { it.toFarmer() }
    } catch (e: Exception) {
        emptyList()
    }

    suspend fun addFarmer(farmer: Farmer) {
        db.collection("farmers").document(farmer.id).set(
            FarmerDto(
                name = farmer.name,
                region = farmer.region,
                crop = farmer.crop,
                method = farmer.method,
                yieldTons = farmer.yieldTons.toDouble(),
                chemicalRisk = farmer.chemicalRisk,
                certifiedOrganic = farmer.certifiedOrganic,
                stockKg = farmer.stockKg.toDouble(),
                pricePerKg = farmer.pricePerKg.toDouble(),
            )
        )
    }

    suspend fun getProducts(): List<Product> = try {
        db.collection("products").get().documents.map { it.toProduct() }
    } catch (e: Exception) {
        emptyList()
    }

    suspend fun getProductsByCondition(condition: String): List<Product> = try {
        db.collection("products")
            .where { "recommendedFor" equalTo condition }
            .get().documents.map { it.toProduct() }
    } catch (e: Exception) {
        emptyList()
    }

    suspend fun getPatients(): List<Patient> = try {
        db.collection("patients").get().documents.map { it.toPatient() }
    } catch (e: Exception) {
        emptyList()
    }

    suspend fun getPatientById(id: String): Patient? = try {
        val doc = db.collection("patients").document(id).get()
        if (doc.exists) doc.toPatient() else null
    } catch (e: Exception) {
        null
    }

    suspend fun getUser(uid: String): User? = try {
        val doc = db.collection("users").document(uid).get()
        if (doc.exists) doc.toUser() else null
    } catch (e: Exception) {
        null
    }

    suspend fun createUser(user: User) {
        db.collection("users").document(user.id).set(
            UserDocDto(name = user.name, email = user.email, role = user.role.name)
        )
    }
}
