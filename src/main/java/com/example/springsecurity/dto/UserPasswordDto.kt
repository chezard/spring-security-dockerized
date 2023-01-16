package com.example.springsecurity.dto

import com.example.springsecurity.model.Role

data class UserPasswordDto @JvmOverloads constructor(
    val id: String? = null,
    val username: String?,
    val password: String?,
    val role: Role
)