package com.example.repository

import com.example.DBModels.CategoryDB
import com.example.DBModels.ProductDB

class Categories {
    var categories: MutableMap<Int, CategoryDB> = mutableMapOf(1 to CategoryDB(1, "Category 1"), 2 to CategoryDB(2, "Category 2"))
    var idIterator: Int = 2
}
var categories:Categories = Categories()

fun getByCategory(categoryId: Int): Map<Int, ProductDB> {
    return products.products.filter { it.value.categoryId == categoryId};
}

fun getCategories(): List<CategoryDB> {
    return categories.categories.values.toList();
}