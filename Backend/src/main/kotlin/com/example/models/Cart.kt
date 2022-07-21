package com.example.models

import com.example.plugins.UserSession
import com.example.repository.addToCart
import com.example.repository.clearCart
import com.example.repository.getCart
import com.example.repository.removeFromCart
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*


fun Route.cartRouting() {
    route("/cart") {
        get {
            val userInfo = userService.getUserInfo(call.sessions.get<UserSession>()!!.id)

            call.respond(getCart(userInfo.id))
        }
        delete("/all") {
            val userInfo = userService.getUserInfo(call.sessions.get<UserSession>()!!.id)
            clearCart(userInfo.id);
            call.respond("OK")
        }
        delete{
            val productId = call.receive<Int>();
            val userInfo = userService.getUserInfo(call.sessions.get<UserSession>()!!.id)

            removeFromCart(userInfo.id, productId);
            call.respond("OK")
        }
        post{
            val userInfo = userService.getUserInfo(call.sessions.get<UserSession>()!!.id)

            val productId = call.receive<Int>();
            addToCart(userInfo.id, productId);
            call.respond("OK")
        }
    }
}