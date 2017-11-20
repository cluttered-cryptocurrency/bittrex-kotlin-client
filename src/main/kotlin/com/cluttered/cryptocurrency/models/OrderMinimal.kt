package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName

data class OrderMinimal(
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("Rate") val rate: Double
)