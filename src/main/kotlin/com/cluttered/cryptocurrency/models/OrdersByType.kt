package com.cluttered.cryptocurrency.models

data class OrdersByType(
        val sell: List<MinimalOrder>?,
        val buy: List<MinimalOrder>?
)