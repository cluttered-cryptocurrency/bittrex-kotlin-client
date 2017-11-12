package com.cluttered.cryptocurrency.models

data class ApiResponse<T>(
        val success: Boolean,
        val message: String,
        val result: List<T>
)