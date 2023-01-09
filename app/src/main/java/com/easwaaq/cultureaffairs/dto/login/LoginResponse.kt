package com.easwaaq.cultureaffairs.dto.login

@kotlinx.serialization.Serializable
data class LoginResponse(
	val data: Data? = null,
	val success: Boolean? = null,
	val message: String? = null
)
@kotlinx.serialization.Serializable
data class Data(
	val user: User? = null,
	val token: String? = null
)
@kotlinx.serialization.Serializable
data class User(
	val name: String? = null,
	val mobile: String? = null,
	val id: Int? = null,
	val email: String? = null
)