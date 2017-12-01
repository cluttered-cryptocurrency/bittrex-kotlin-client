package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

data class Market(
        @SerializedName("MarketCurrency") val marketCurrency: String,
        @SerializedName("BaseCurrency") val baseCurrency: String,

        @SerializedName("MarketCurrencyLong") val marketCurrencyLong: String,
        @SerializedName("BaseCurrencyLong") val baseCurrencyLong: String,

        @SerializedName("MinTradeSize") val minTradeSize: Double,

        @SerializedName("MarketName") val marketName: String,

        @SerializedName("IsActive") val isActive: Boolean,

        @SerializedName("Created") val created: ZonedDateTime,

        @SerializedName("LogoUrl") val logoUrl: String? = null
)