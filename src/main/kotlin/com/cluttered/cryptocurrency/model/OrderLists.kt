package com.cluttered.cryptocurrency.model

data class OrderLists(
        val buy: List<Order>,
        val sell: List<Order>
)