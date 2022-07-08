package com.example.models

import com.example.repository.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@kotlinx.serialization.Serializable
data class UserWithProductId(val productId:Int, val userId:Int)

fun Route.cartRouting() {
    route("/cart") {
        get ("{id}"){
            val id = Integer.parseInt(call.parameters["id"])
            call.respond(getCart(id))
        }
        delete("/all") {
            clearCart(call.receive<Int>());
            call.respond("OK")
        }
        delete{
            val req = call.receive<UserWithProductId>();
            removeFromCart(req.userId, req.productId);
            call.respond("OK")
        }
        get("create/{id}"){
            val id = Integer.parseInt(call.parameters["id"])
            call.respond(addCart(id))
        }
        post{
            val req = call.receive<UserWithProductId>();
            addToCart(req.userId, req.productId);
            call.respond("OK")
        }
    }
}