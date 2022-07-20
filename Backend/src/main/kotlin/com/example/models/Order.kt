package com.example.models

import com.example.plugins.UserSession
import com.example.repository.addOrder
import com.example.services.UserProvider
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

@kotlinx.serialization.Serializable
data class OrderApi ( val userId:Int, val address:String)
val userService = UserProvider
fun Route.orderRouting() {
    route("/order") {
        get ("{id}"){
            val userSession = call.sessions.get<UserSession>();
            val userInfo = userService.getUserInfo(userSession!!.id)
            val x = userInfo;
            val id = Integer.parseInt(call.parameters["id"])
            if(userInfo == null)
                call.respond("null")
            else{
                call.respond(userInfo)
            }
        }
        put{
            val req = call.receive<OrderApi>();
            addOrder(req.userId, req.address);
            call.respond("ok")
        }
    }
}