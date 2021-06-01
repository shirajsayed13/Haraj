package com.example.harajtask.model

data class AuthToken(
    val accessToken: String,
    val tokenType: String,
    val expiryTime: String,
)