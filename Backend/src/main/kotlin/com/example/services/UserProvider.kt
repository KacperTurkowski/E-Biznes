package com.example.services

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import com.example.*;
import com.example.DBModels.UserDB
import com.example.repository.addUser
import com.example.repository.getUser
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

object UserProvider {

    private val httpClient1: HttpClient = httpClient

    suspend fun getUserInfo(sessionId: String): UserDB {
        val response = httpClient1.get("https://www.googleapis.com/oauth2/v2/userinfo") {
            headers {
                append(HttpHeaders.Authorization, "Bearer $sessionId")
            }
        }

        if(response.status == HttpStatusCode.OK){
            val googleUser = UserDB(response.body<JsonObject>()["name"].toString(), response.body<JsonObject>()["id"].toString());
            addUser(googleUser)
            return getUser(googleUser.id)!!
            } else{
            val responseGithub = httpClient1.get("https://api.github.com/user") {
                headers {
                    append(HttpHeaders.Authorization, "Bearer $sessionId")
                }
            }
            val githubUser = UserDB(responseGithub.body<JsonObject>()["name"].toString(), responseGithub.body<JsonObject>()["id"].toString());
            addUser(githubUser)
            return getUser(githubUser.id)!!
        }

    }
}