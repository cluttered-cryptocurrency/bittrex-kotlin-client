package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.time.Instant

data class Market(
        @SerializedName("MarketName") val marketName: String,
        @SerializedName("IsActive") val isActive: Boolean,
        @SerializedName("MinTradeSize") val minTradeSize: BigDecimal,

        @SerializedName("MarketCurrency") val marketCurrency: String,
        @SerializedName("MarketCurrencyLong") val marketCurrencyLong: String,

        @SerializedName("BaseCurrency") val baseCurrency: String,
        @SerializedName("BaseCurrencyLong") val baseCurrencyLong: String,

        @SerializedName("Notice") val notice: String?,
        @SerializedName("IsSponsored") val isSponsored: Boolean,
        @SerializedName("Created") val created: Instant,
        @SerializedName("LogoUrl") val logoUrl: String
)