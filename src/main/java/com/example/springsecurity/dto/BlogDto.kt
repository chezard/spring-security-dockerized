package com.example.springsecurity.dto

data class BlogDto @JvmOverloads constructor(
    val id: String? = null,
    val user: UserDto,
    val content: String
) {
}