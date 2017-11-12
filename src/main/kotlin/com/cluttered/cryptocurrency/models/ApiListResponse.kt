package com.cluttered.cryptocurrency.models

data class ApiListResponse<T>(
        val success: Boolean,
        val message: String,
        val result: List<T>
)