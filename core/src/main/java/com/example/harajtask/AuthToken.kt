package com.example.harajtask

data class AuthToken(
    val accessToken: String,
    val tokenType: String,
    val expiryTime: String,
)