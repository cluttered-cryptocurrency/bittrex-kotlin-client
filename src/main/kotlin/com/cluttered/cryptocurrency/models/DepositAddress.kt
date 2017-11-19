package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName

data class DepositAddress(
        @SerializedName("Currency") val currency: String,
        @SerializedName("Address") val address: String
)