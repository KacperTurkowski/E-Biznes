package com.example.DBModels

@kotlinx.serialization.Serializable
data class UserDB (
    val id: Int,
    val name: String
)