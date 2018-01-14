package com.cluttered.cryptocurrency.model

data class OrderLists(
        val buy: MutableList<Order>,
        val sell: MutableList<Order>
)