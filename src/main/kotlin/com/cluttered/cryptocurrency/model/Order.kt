package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("Quantity") val quantity: Double,
    @SerializedName("Rate") val rate: Double
)