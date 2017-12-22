package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class Balance(
        @SerializedName("Currency") val currency: String,
        @SerializedName("Balance") val balance: Double,
        @SerializedName("Available") val available: Double,
        @SerializedName("Pending") val pending: Double,
        @SerializedName("CryptoAddress") val cryptoAddress: String?,
        @SerializedName("Requested") val requested: Boolean
)