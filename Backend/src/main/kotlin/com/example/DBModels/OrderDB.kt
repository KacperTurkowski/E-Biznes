package com.example.DBModels

@kotlinx.serialization.Serializable
data class OrderDB (
    val id: Int,
    val products: MutableList<ProductDB>,
    val userId : Int
)