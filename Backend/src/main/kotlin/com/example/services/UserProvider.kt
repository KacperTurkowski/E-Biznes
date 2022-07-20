package com.example.services

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import com.example.*;
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class UserInfo (
    val login: String,
    val id: String
)

object UserProvider {

    private val httpClient1: HttpClient = httpClient

    suspend fun getUserInfo(sessionId: String): UserInfo {
        val response = httpClient1.get("https://www.googleapis.com/oauth2/v2/userinfo") {
            headers {
                append(HttpHeaders.Authorization, "Bearer $sessionId")
            }
        }
        return if(response.status == HttpStatusCode.OK){
            runBlocking {
                UserInfo(response.body<JsonObject>()["name"].toString(), response.body<JsonObject>()["id"].toString());
            }
        } else{
            val responseGithub = httpClient1.get("https://api.github.com/user") {
                headers {
                    append(HttpHeaders.Authorization, "Bearer $sessionId")
                }
            }
            runBlocking{
                UserInfo(responseGithub.body<JsonObject>()["name"].toString(), responseGithub.body<JsonObject>()["id"].toString());
            }
        }

    }
}