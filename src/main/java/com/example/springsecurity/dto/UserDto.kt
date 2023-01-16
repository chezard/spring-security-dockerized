package com.example.springsecurity.dto

import com.example.springsecurity.model.Role

data class UserDto @JvmOverloads constructor(
    val id: String? = null,
    val username: String?,
    val role: Role?
)