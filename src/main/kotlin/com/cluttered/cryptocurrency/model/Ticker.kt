package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Ticker(
        @SerializedName("Bid") val bid: BigDecimal,
        @SerializedName("Ask") val ask: BigDecimal,
        @SerializedName("Last") val last: BigDecimal
)