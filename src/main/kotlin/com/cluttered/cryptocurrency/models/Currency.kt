package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName

data class Currency(
        @SerializedName("Currency") val currency: String,
        @SerializedName("CurrencyLong") val currencyLong: String,

        @SerializedName("MinConfirmation") val minConfirmation : Int,
        @SerializedName("TxFee") val txFee : Double,

        @SerializedName("CoinType") val coinType : String,
        @SerializedName("BaseAddress") val baseAddress : String? = null,

        @SerializedName("IsActive") val isActive: Boolean
)