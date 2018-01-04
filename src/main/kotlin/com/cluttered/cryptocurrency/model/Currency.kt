package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Currency(
        @SerializedName("Currency") val currency: String,
        @SerializedName("CurrencyLong") val currencyLong: String,
        @SerializedName("MinConfirmation") val minConfirmations: Int,
        @SerializedName("TxFee") val txFee: BigDecimal,
        @SerializedName("IsActive") val isActive: Boolean,
        @SerializedName("CoinType") val coinType: String,

        @SerializedName("BaseAddress") val baseAddress: String?,
        @SerializedName("Notice") val notice: String?
)