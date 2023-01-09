package com.easwaaq.cultureaffairs.network

import com.easwaaq.cultureaffairs.dto.login.LoginResponse
import com.easwaaq.cultureaffairs.network.login.LoginParam

interface AuthService {
    suspend fun login(param: LoginParam): LoginResponse?
}