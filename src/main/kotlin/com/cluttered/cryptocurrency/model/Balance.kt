package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Balance(
        @SerializedName("Currency") val currency: String,
        @SerializedName("Balance") val balance: BigDecimal,
        @SerializedName("Available") val available: BigDecimal,
        @SerializedName("Pending") val pending: BigDecimal,
        @SerializedName("CryptoAddress") val cryptoAddress: String?,
        @SerializedName("Requested") val requested: Boolean
)