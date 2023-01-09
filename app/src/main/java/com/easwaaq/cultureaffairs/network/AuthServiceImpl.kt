package com.easwaaq.cultureaffairs.network

import android.util.Log
import com.easwaaq.cultureaffairs.BuildConfig
import com.easwaaq.cultureaffairs.dto.login.LoginResponse
import com.easwaaq.cultureaffairs.network.login.LoginParam
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*

class AuthServiceImpl(private val client: HttpClient) : AuthService {
    override suspend fun login(param: LoginParam): LoginResponse? {
        return try {
            client.post<LoginResponse>("${BuildConfig.BASE_URL}login") {
                body = param
            }
        } catch (e: Exception) {
            Log.e(NetworkModule.TAG, e.toString())
            null
        }
    }


    companion object{
        fun create():AuthServiceImpl = AuthServiceImpl(NetworkModule.ktorHttpClient)
    }

}