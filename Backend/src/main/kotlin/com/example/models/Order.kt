package com.example.models

import com.example.DBModels.CartDB
import com.example.repository.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.orderRouting() {
    route("/order") {
        get ("{id}"){
            val id = Integer.parseInt(call.parameters["id"])
            call.respond(getOrders(id))
        }
        put{
            val req = call.receive<CartDB>();
            addOrder(req);
        }
    }
}