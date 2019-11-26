package com.example.myapplication1.Data.remote.LoginApi.Register

import android.accounts.NetworkErrorException
import com.example.myapplication1.Data.remote.LoginApi.ApiConnectionLogin
import com.example.myapplication1.model.Login
import com.example.myapplication1.model.LoginInformation
import com.example.myapplication1.model.RegisterResponse
import com.example.myapplication1.model.UserToRegister

class RemoteRepositoryRetrofitRegister(val ApiConnectionLogin: ApiConnectionLogin) :
    RemoteRepositoryRegister {
    override suspend fun register(
        username: String,
        password: String,
        email: String
    ): RegisterResponse {
        val UserToRegister = UserToRegister(username, password, email)
        val response = ApiConnectionLogin.register(UserToRegister)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw NetworkErrorException()
        }
    }
}