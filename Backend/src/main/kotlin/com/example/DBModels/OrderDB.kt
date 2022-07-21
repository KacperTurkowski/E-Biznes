package com.example.DBModels

@kotlinx.serialization.Serializable
data class OrderDB (
    val id: Int,
    val products: MutableList<ProductDB>,
    val userId : String,
    val address: String,
    val price: Double,
    val date: String
)