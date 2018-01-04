package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Order(
        @SerializedName("Quantity") val quantity: BigDecimal,
        @SerializedName("Rate") val rate: BigDecimal
)