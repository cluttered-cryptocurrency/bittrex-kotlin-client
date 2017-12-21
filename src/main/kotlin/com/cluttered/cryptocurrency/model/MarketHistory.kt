package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class MarketHistory(
        @SerializedName("Id") val id: Long,
        @SerializedName("TimeStamp") val timestamp: ZonedDateTime,
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("Price") val price: Double,
        @SerializedName("Total") val total: Double,
        @SerializedName("FillType") val fillType: FillType,
        @SerializedName("OrderType") val orderType: OrderType
) {
    enum class FillType {
        FILL,
        PARTIAL_FILL
    }

    enum class OrderType {
        BUY,
        SELL
    }
}