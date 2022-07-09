package com.example.models

import com.example.repository.addOrder
import com.example.repository.getOrders
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@kotlinx.serialization.Serializable
data class OrderApi ( val userId:Int, val address:String)

fun Route.orderRouting() {
    route("/order") {
        get ("{id}"){
            val id = Integer.parseInt(call.parameters["id"])
            call.respond(getOrders(id))
        }
        put{
            val req = call.receive<OrderApi>();
            addOrder(req.userId, req.address);
            call.respond("ok")
        }
    }
}