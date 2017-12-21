package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class Tick(
        @SerializedName("Bid") val bid: Double,
        @SerializedName("Ask") val ask: Double,
        @SerializedName("Last") val last: Double
)