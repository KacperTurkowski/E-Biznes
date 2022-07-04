package com.example.repository

import com.example.DBModels.CartDB

class Carts {
    var carts: MutableMap<Int, CartDB> = mutableMapOf(1 to CartDB(1, 1, mutableListOf()))
    var idIterator: Int = 1
}
var carts:Carts = Carts()

fun getCart(userId: Int): CartDB {
    return carts.carts[userId]!!;
}

fun addCart(userId: Int) {
    carts.idIterator++;
    carts.carts[userId] = CartDB(carts.idIterator, userId, mutableListOf());
}

fun addToCart(userId: Int, productId: Int) {
    carts.carts[userId]?.products?.add(products.products[productId]!!)
}

fun removeFromCart(userId: Int, productId: Int) {
    carts.carts[userId]?.products?.remove(products.products[productId]!!)
}

fun clearCart(userId: Int) {
    carts.carts[userId]?.products?.clear()
}