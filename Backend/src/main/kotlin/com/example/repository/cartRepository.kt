package com.example.repository

import com.example.DBModels.CartDB
import com.example.DBModels.ProductInCart

class Carts {
    var carts: MutableMap<Int, CartDB> = mutableMapOf(1 to CartDB(1, 1, mutableListOf(
        ProductInCart(getProducts()[1]!!, 1),
        ProductInCart(getProducts()[2]!!, 2)
    )))
    var idIterator: Int = 2
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
    if(!carts.carts[userId]?.products?.any{it.product.id == productId}!!){
        carts.carts[userId]?.products?.add(ProductInCart(products.products[productId]!!, 1))
    }
    else{
        carts.carts[userId]?.products?.first{it.product.id == productId}!!.count++;
    }
}

fun removeFromCart(userId: Int, productId: Int) {
    carts.carts[userId]?.products?.first { it.product.id == productId }?.count = carts.carts[userId]?.products?.first { it.product.id == productId }?.count!! - 1;
    if(carts.carts[userId]?.products?.first { it.product.id == productId }?.count!! < 1)
        carts.carts[userId]?.products?.remove(carts.carts[userId]?.products?.first { it.product.id == productId })
}

fun clearCart(userId: Int) {
    carts.carts[userId]?.products?.clear()
}