package com.cluttered.cryptocurrency.models

import com.cluttered.cryptocurrency.types.FillType
import com.cluttered.cryptocurrency.types.OrderType
import com.google.gson.annotations.SerializedName
import java.util.*

data class Trade(
        @SerializedName("Id") val id: Long,
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("Price") val price: Double,
        @SerializedName("Total") val total: Double,
        @SerializedName("FillType") val fillType: FillType,
        @SerializedName("OrderType") val orderType: OrderType,
        @SerializedName("TimeStamp") val timestamp: Date
)