package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarketSummary(
        @SerializedName("MarketName") val marketName: String,

        @SerializedName("High") val high: Double,
        @SerializedName("Low") val low: Double,

        @SerializedName("Bid") val bid: Double,
        @SerializedName("Ask") val ask: Double,

        @SerializedName("Last") val last: Double,

        @SerializedName("Volume") val volume: Double,
        @SerializedName("BaseVolume") val baseVolume: Double,

        @SerializedName("OpenBuyOrders") val openBuyOrders: Int,
        @SerializedName("OpenSellOrders") val opeSellOrders: Int,

        @SerializedName("PrevDay") val previousDay: Double,
        @SerializedName("TimeStamp") val timestamp: Date,

        @SerializedName("DisplayMarketName") val displayMarketName: String? = null,
        @SerializedName("Created") val created: Date
)