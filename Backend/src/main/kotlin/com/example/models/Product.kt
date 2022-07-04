package com.example.models

import com.example.DBModels.ProductDB
import com.example.repository.addProduct
import com.example.repository.getProduct
import com.example.repository.getProducts
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.productRouting() {
    route("/products") {
        get {
            val res = getProducts();
            call.respond(res)
        }
        get ("{id}"){
            val id = Integer.parseInt(call.parameters["id"])
            call.respond(getProduct(id))
        }
        put {
            val product = call.receive<ProductDB>()
            addProduct(product);
        }
    }
}