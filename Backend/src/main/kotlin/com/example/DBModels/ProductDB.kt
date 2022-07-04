package com.example.DBModels

@kotlinx.serialization.Serializable
data class ProductDB (
    var id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val categoryId: Int
)