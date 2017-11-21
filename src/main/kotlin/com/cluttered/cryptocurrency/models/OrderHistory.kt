package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class OrderHistory(
        @SerializedName("OrderUuid") val orderUUID: UUID,
        @SerializedName("Exchange") val exchange: String,
        @SerializedName("TimeStamp") val timestamp: Date,
        @SerializedName("OrderType") val orderType: String,
        @SerializedName("Limit") val limit: Double,
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("QuantityRemaining") val quantityRemaining: Double,
        @SerializedName("Commission") val commission: Double,
        @SerializedName("Price") val price: Double,
        @SerializedName("PricePerUnit") val pricePerUnit: Double,
        @SerializedName("IsConditional") val isConditional: Boolean,
        @SerializedName("Condition") val condition: String,
        @SerializedName("ConditionTarget") val conditionTarget: String,
        @SerializedName("ImmediateOrCancel") val immediateOrCancel: Boolean
)