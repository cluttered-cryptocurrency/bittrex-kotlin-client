package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.time.ZonedDateTime

data class MarketSummary(
        @SerializedName("MarketName") val marketName: String,
        @SerializedName("TimeStamp") val timestamp: ZonedDateTime,

        @SerializedName("High") val high: BigDecimal,
        @SerializedName("Low") val low: BigDecimal,

        @SerializedName("Bid") val bid: BigDecimal,
        @SerializedName("Ask") val ask: BigDecimal,
        @SerializedName("Last") val last: BigDecimal,

        @SerializedName("Volume") val volume: BigDecimal,
        @SerializedName("BaseVolume") val baseVolume: BigDecimal,

        @SerializedName("OpenBuyOrders") val openBuyOrders: Int,
        @SerializedName("OpenSellOrders") val openSellOrders: Int,

        @SerializedName("PrevDay") val previousDay: BigDecimal,
        @SerializedName("Created") val created: ZonedDateTime
)