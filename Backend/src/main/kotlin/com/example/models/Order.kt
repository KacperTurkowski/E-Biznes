package com.example.models

import com.example.plugins.UserSession
import com.example.repository.addOrder
import com.example.repository.getOrders
import com.example.services.UserProvider
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*

val userService = UserProvider
fun Route.orderRouting() {
    route("/order") {
        get {
            val userSession = call.sessions.get<UserSession>();
            val userInfo = userService.getUserInfo(userSession!!.id)
            call.respond(getOrders(userInfo.id))
        }
        put{
            val address = call.receive<String>();
            val userInfo = userService.getUserInfo(call.sessions.get<UserSession>()!!.id)
            addOrder(userInfo.id, address);
            call.respond("ok")
        }
    }
}