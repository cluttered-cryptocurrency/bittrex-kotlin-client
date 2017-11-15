package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Balance(
        @SerializedName("Currency") val currency: String,
        @SerializedName("Balance") val balance: Double,
        @SerializedName("Available") val available: Double,
        @SerializedName("Pending") val pending: Double,
        @SerializedName("CryptoAddress") val cryptoAddress: String?,
        @SerializedName("Requested") val requested: Boolean,
        @SerializedName("Uuid") val uuid: UUID?
)