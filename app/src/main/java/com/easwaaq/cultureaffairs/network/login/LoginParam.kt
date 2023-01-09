package com.easwaaq.cultureaffairs.network.login

@kotlinx.serialization.Serializable
data class LoginParam(val email: String, val password: String)