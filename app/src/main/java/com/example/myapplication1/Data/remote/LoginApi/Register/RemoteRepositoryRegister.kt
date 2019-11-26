package com.example.myapplication1.Data.remote.LoginApi.Register

import com.example.myapplication1.model.Login
import com.example.myapplication1.model.RegisterResponse

interface RemoteRepositoryRegister {
    suspend fun register(username: String, password: String, email: String): RegisterResponse
}