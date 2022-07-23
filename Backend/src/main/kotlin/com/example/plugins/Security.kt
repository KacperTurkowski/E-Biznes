package com.example.plugins

import com.example.httpClient
import com.example.repository.addUser
import com.example.services.UserProvider
import io.ktor.server.auth.*
import io.ktor.util.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.server.locations.*
import io.ktor.http.*
import io.ktor.server.sessions.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.p

fun Application.configureSecurity(client1: HttpClient = httpClient ) {
    configureSessions()

    install(Authentication) {
        session<UserSession>("auth-session") {
            validate { it }
            challenge {
                call.respondRedirect("/login")
            }
        }
        oauth("auth-oauth-google") {
            skipWhen { call -> call.sessions.get<UserSession>() != null }
            urlProvider = { "http://localhost:8080/callback" }
            providerLookup = {
                OAuthServerSettings.OAuth2ServerSettings(
                    name = "google",
                    authorizeUrl = "https://accounts.google.com/o/oauth2/auth",
                    accessTokenUrl = "https://accounts.google.com/o/oauth2/token",
                    requestMethod = HttpMethod.Post,
                    clientId = "77175158456-2c2sn9kd30g8c1m37voa496pfsabd0sj.apps.googleusercontent.com",
                    clientSecret = "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",
                    defaultScopes = listOf("https://www.googleapis.com/auth/userinfo.profile")
                )
            }
            client = client1
        }
        oauth("auth-oauth-github") {
            urlProvider = { "http://localhost:8080/callback_github" }
            providerLookup = {
                OAuthServerSettings.OAuth2ServerSettings(
                    name = "github",
                    authorizeUrl = "https://github.com/login/oauth/authorize",
                    accessTokenUrl = "https://github.com/login/oauth/access_token",
                    requestMethod = HttpMethod.Post,
                    clientId = "facb9d0a1f30ef385c2e",
                    clientSecret = "23fc5b381c790447784332393b49a0fd3ca286c7",
                )
            }
            client = httpClient
        }
    }

    configureHTTP()
    routing {
        get("") {
            call.respondHtml {
                body {
                    p {
                        a("/auth") { +"Login with Google" }
                    }
                }
            }
        }
        authenticate("auth-oauth-google") {
            get("/auth") {

            }
            get("/callback") {
                val principal: OAuthAccessTokenResponse.OAuth2? = call.principal()
                call.sessions.set(UserSession(principal?.accessToken.toString(), 0))
                call.respondRedirect("http://localhost:3000/")
            }
        }
        authenticate("auth-oauth-github") {
            get("/auth_github") {
                call.respondRedirect("/callback_github")
            }

            get("/callback_github") {
                val principal: OAuthAccessTokenResponse.OAuth2? = call.authentication.principal()
                call.sessions.set(UserSession(principal?.accessToken.toString(), 0))
                call.respondRedirect("http://localhost:3000/")
            }
        }

        get("/auth/logout") {
            if (call.sessions.get<UserSession>() != null) {
                call.sessions.clear<UserSession>()
                call.respondRedirect("http://localhost:3000/")
            } else {
                call.respond(HttpStatusCode.Forbidden)
            }
        }
    }
}
