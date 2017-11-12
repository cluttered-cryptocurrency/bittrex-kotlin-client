package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName

data class Ticker(
        @SerializedName("Bid") val bid: Double,
        @SerializedName("Ask") val ask: Double,
        @SerializedName("Last") val last: String
)