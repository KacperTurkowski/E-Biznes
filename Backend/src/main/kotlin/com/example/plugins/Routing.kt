package com.example.plugins

import com.example.models.cartRouting
import com.example.models.categoryRouting
import com.example.models.orderRouting
import com.example.models.productRouting
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.locations.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(Locations) {
    }

    routing {
        productRouting()
        cartRouting()
        authenticate("auth-session") {
            orderRouting()
        }
        categoryRouting()
    }
}

@Location("/location/{name}")
class MyLocation(val name: String, val arg1: Int = 42, val arg2: String = "default")
@Location("/type/{name}")
data class Type(val name: String) {
    @Location("/edit")
    data class Edit(val type: Type)

    @Location("/list/{page}")
    data class List(val type: Type, val page: Int)
}
