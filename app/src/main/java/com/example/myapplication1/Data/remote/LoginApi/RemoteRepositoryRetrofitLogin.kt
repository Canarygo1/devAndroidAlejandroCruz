package com.example.myapplication1.Data.remote.LoginApi

import android.accounts.NetworkErrorException
import com.example.myapplication1.model.Login
import com.example.myapplication1.model.LoginInformation


class RemoteRepositoryRetrofitLogin(val ApiConnectionLogin: ApiConnectionLogin) :
    RemoteRepositoryLogin {
    override suspend fun get(username: String, password: String): Login {
        val LoginInformation = LoginInformation(username, password)
        val response = ApiConnectionLogin.getLogin(LoginInformation)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw NetworkErrorException()
        }
    }
}