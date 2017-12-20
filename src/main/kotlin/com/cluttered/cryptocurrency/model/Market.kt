package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class Market(
        @SerializedName("MarketName") val marketName: String,
        @SerializedName("IsActive") val isActive: Boolean,
        @SerializedName("MinTradeSize") val minTradeSize: Double

//        @SerializedName("MarketCurrency") val marketCurrency: String,
//        @SerializedName("MarketCurrencyLong") val marketCurrencyLong: String,
//
//        @SerializedName("BaseCurrency") val baseCurrency: String,
//        @SerializedName("BaseCurrencyLong") val baseCurrencyLong: String,
//
//        @SerializedName("Notice") val notice: String,
//        @SerializedName("IsSponsored") val isSponsored: Boolean,
//        @SerializedName("Created") val created: ZonedDateTime,
//        @SerializedName("LogoUrl") val logoUrl: String
)