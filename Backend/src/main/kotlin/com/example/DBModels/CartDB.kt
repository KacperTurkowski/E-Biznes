package com.example.DBModels

@kotlinx.serialization.Serializable
data class CartDB (
    val id: Int,
    val userId: Int,
    val products: MutableList<ProductDB>
)