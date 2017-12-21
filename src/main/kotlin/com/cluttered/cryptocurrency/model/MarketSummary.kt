package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class MarketSummary(
        @SerializedName("MarketName") val marketName: String,
        @SerializedName("TimeStamp") val timestamp: ZonedDateTime,

        @SerializedName("High") val high: Double,
        @SerializedName("Low") val low: Double,

        @SerializedName("Bid") val bid: Double,
        @SerializedName("Ask") val ask: Double,
        @SerializedName("Last") val last: Double,

        @SerializedName("Volume") val volume: Double,
        @SerializedName("BaseVolume") val baseVolume: Double,

        @SerializedName("OpenBuyOrders") val openBuyOrders: Int,
        @SerializedName("OpenSellOrders") val openSellOrders: Int,

        @SerializedName("PrevDay") val previousDay: Double,
        @SerializedName("Created") val created: ZonedDateTime
)