package com.example.myapplication1.Data

import com.example.myapplication1.model.Login
import com.example.myapplication1.model.LoginInformation
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface ApiConnectionLogin {
    @POST("auth")
    suspend fun getLogin( @Body  LoginInformation: LoginInformation): Response<Login>

}

object RetrofitLoginFactory {
    const val BASE_URL = "http://10.0.2.2:3000/"
    fun getLoginApi(): ApiConnectionLogin {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(ApiConnectionLogin::class.java)
    }
}