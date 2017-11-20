package com.cluttered.cryptocurrency.models

data class OrdersByType(
        val sell: List<OrderMinimal>?,
        val buy: List<OrderMinimal>?
)