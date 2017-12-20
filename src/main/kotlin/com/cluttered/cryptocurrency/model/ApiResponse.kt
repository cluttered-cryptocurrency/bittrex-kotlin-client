package com.cluttered.cryptocurrency.model

data class ApiResponse<out T>(
    val success: Boolean,
    val message: String,
    val result: T
)