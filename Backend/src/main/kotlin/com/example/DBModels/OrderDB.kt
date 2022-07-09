package com.example.DBModels

import java.sql.Date
import java.time.LocalDate

@kotlinx.serialization.Serializable
data class OrderDB (
    val id: Int,
    val products: MutableList<ProductDB>,
    val userId : Int,
    val address: String,
    val price: Double,
    val date: String
)