package com.example.DBModels

@kotlinx.serialization.Serializable
data class UserDB (
    val name: String,
    val id: String
)