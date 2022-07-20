package com.example.plugins

import io.ktor.http.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureHTTP() {
    install(CORS) {
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Delete)
        exposeHeader(HttpHeaders.Authorization)
        exposeHeader(HttpHeaders.AccessControlAllowOrigin)
        allowHeader(HttpHeaders.Authorization)
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.AccessControlAllowOrigin)
        allowNonSimpleContentTypes = true
        allowCredentials = true
        allowSameOrigin = true
        anyHost()
        allowHeader("user_session")
        exposeHeader("user_session")
    }

}
