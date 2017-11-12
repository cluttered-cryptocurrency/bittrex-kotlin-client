package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName

data class Order(
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("Rate") val rate: Double
)