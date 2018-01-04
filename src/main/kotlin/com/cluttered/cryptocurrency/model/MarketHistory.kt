package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.time.ZonedDateTime

data class MarketHistory(
        @SerializedName("Id") val id: Long,
        @SerializedName("TimeStamp") val timestamp: ZonedDateTime,
        @SerializedName("Quantity") val quantity: BigDecimal,
        @SerializedName("Price") val price: BigDecimal,
        @SerializedName("Total") val total: BigDecimal,
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