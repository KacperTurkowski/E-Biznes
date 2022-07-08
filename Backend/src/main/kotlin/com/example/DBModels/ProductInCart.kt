package com.example.DBModels

@kotlinx.serialization.Serializable
class ProductInCart (
    val product: ProductDB,
    var count: Int
)