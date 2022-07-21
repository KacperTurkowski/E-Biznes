package com.example.DBModels

@kotlinx.serialization.Serializable
data class CartDB (
    val id: Int,
    val userId: String,
    val products: MutableList<ProductInCart>
)