package com.example.repository

import com.example.DBModels.OrderDB
import java.time.LocalDate.now

class Orders {
    var orders: MutableMap<Int, OrderDB> = mutableMapOf(1 to OrderDB(1, mutableListOf(), 1, "address 1", 100.5, now().toString()),
       2 to OrderDB(2, mutableListOf(), 1, "address 2", 120.0, now().toString()))

    var idIterator: Int = 2
}
var orders:Orders = Orders()

fun getOrders(userId: Int): List<OrderDB> {
    return orders.orders.filter { it.value.userId == userId }.values.toList();
}

fun addOrder(userId: Int, address: String) {
    orders.idIterator++;
    val cart = carts.carts[userId] ?: return;
    val price = cart.products.map { it.product.price * it.count }.sum();
    val order = OrderDB(orders.idIterator, cart.products.map{it.product}.toMutableList(), cart.userId, address, price, now().toString());
    orders.orders[orders.idIterator] = order;
}