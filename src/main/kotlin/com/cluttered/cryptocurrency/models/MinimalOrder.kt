package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName

data class MinimalOrder(
        @SerializedName("Type") val type: Int,
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("Rate") val rate: Double
)