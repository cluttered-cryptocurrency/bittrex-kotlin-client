package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Market(
        @SerializedName("MarketCurrency") val marketCurrency: String,
        @SerializedName("BaseCurrency") val baseCurrency: String,

        @SerializedName("MarketCurrencyLong") val marketCurrencyLong: String,
        @SerializedName("BaseCurrencyLong") val baseCurrencyLong: String,

        @SerializedName("MinTradeSize") val minTradeSize: Double,

        @SerializedName("MarketName") val marketName: String,

        @SerializedName("IsActive") val isActive: Boolean,

        @SerializedName("Created") val created: Date,

        @SerializedName("LogoUrl") val logoUrl: String? = null
)