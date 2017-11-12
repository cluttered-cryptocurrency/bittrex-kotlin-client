package com.cluttered.cryptocurrency.models

data class OrdersByType(
        val sell: List<Order>?,
        val buy: List<Order>?
)