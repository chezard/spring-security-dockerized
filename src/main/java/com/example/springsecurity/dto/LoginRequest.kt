package com.example.springsecurity.dto

data class LoginRequest constructor(
    val username: String,
    val password: String
) {

}