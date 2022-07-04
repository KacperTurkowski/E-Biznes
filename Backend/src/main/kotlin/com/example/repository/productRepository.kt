package com.example.repository

import com.example.DBModels.ProductDB

class Products {
    var products: MutableMap<Int, ProductDB> = mutableMapOf(1 to ProductDB(1, "Product 1", 120.1, "Opis 1", 1),
        2 to ProductDB(3, "Product 2", 20.1, "Opis 2", 1),)

    var idIterator: Int = 2
}
var products:Products = Products()

fun getProducts(): MutableMap<Int, ProductDB> {
    return products.products;
}

fun getProduct(productId: Int): ProductDB {
    return products.products[productId]!!;
}

fun addProduct(product: ProductDB) {
    products.idIterator++
    product.id = products.idIterator
    products.products.put(products.idIterator, product);
}