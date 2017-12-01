package com.cluttered.cryptocurrency.models

data class ApiResponse<out T>(
        val success: Boolean,
        val message: String,
        val result: T
)