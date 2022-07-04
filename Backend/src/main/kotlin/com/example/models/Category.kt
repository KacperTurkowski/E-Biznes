package com.example.models

import com.example.repository.getByCategory
import com.example.repository.getCategories
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.categoryRouting() {
    route("/category") {
        get ("{id}"){
            val id = Integer.parseInt(call.parameters["id"])
            call.respond(getByCategory(id))
        }
        get{
            call.respond(getCategories())
        }
    }
}