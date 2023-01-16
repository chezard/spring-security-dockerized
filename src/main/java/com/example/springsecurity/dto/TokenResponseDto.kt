package com.example.springsecurity.dto

data class TokenResponseDto constructor(
    val accessToken: String,
    val user: UserDto
) {
}