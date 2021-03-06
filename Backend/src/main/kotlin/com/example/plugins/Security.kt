package com.example.plugins

import com.example.httpClient
import io.ktor.client.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.p

const val address = "http://localhost:3000/"

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
                    clientId = "",
                    clientSecret = "",
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
                    clientId = "",
                    clientSecret = "",
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
                call.respondRedirect(address)
            }
        }
        authenticate("auth-oauth-github") {
            get("/auth_github") {
                call.respondRedirect("/callback_github")
            }

            get("/callback_github") {
                val principal: OAuthAccessTokenResponse.OAuth2? = call.authentication.principal()
                call.sessions.set(UserSession(principal?.accessToken.toString(), 0))
                call.respondRedirect(address)
            }
        }

        get("/auth/logout") {
            if (call.sessions.get<UserSession>() != null) {
                call.sessions.clear<UserSession>()
                call.respondRedirect(address)
            } else {
                call.respond(HttpStatusCode.Forbidden)
            }
        }
    }
}
