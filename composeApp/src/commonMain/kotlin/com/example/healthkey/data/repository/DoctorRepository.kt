package com.example.healthkey.data.repository

import com.example.healthkey.data.model.Conversation
import com.example.healthkey.data.model.Message
import com.example.healthkey.data.model.Patient

interface DoctorRepository {
    suspend fun getPatients(doctorId: String): Result<List<Patient>>
    suspend fun getPatient(patientId: String): Result<Patient>
    suspend fun getConversation(conversationId: String): Result<Conversation>
    suspend fun sendMessage(conversationId: String, text: String): Result<Message>
}
