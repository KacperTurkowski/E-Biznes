package com.example.repository

import com.example.DBModels.UserDB

class Users {
    var users: MutableMap<String, UserDB> = mutableMapOf("1" to UserDB("1", "1"))
}
var users:Users = Users()

fun addUser(user: UserDB){
    if(!users.users.containsKey(user.id)){
        users.users.put(user.id, UserDB(user.name, user.id))
        addCart(user.id)
    }
}

fun getUser(userId: String):UserDB?{
    return if(users.users.containsKey(userId))
        users.users[userId];
    else
        null;
}