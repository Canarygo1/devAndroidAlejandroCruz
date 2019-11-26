package com.example.myapplication1.Data.remote.LoginApi

import com.example.myapplication1.model.Login


interface RemoteRepositoryLogin {
    suspend fun get(username: String, password: String): Login
}