package com.cluttered.cryptocurrency.types

enum class OrderType {
    BUY,
    SELL,
    BOTH;

    override fun toString(): String {
        return super.toString().toLowerCase()
    }
}