package com.example.repository

import com.example.DBModels.CartDB
import com.example.DBModels.OrderDB

class Orders {
    var orders: MutableMap<Int, OrderDB> = mutableMapOf(1 to OrderDB(1, mutableListOf(), 1),
       2 to OrderDB(2, mutableListOf(), 1))

    var idIterator: Int = 0
}
var orders:Orders = Orders()

fun getOrders(userId: Int): Map<Int, OrderDB> {
    return orders.orders.filter { it.value.userId == userId };
}

fun addOrder(cart: CartDB) {
    orders.idIterator++;
    val order = OrderDB(orders.idIterator, cart.products.map{it.product}.toMutableList(), cart.userId)
    orders.orders[orders.idIterator] = order;
}