package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime
import java.util.*

data class OrderHistory(
        @SerializedName("OrderUuid") val orderUuid: UUID,
        @SerializedName("Exchange") val exchange: String,
        @SerializedName("TimeStamp") val timestamp: ZonedDateTime,
        @SerializedName("OrderType") val orderType: OpenOrder.OrderType,
        @SerializedName("Limit") val limit: Double,
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("QuantityRemaining") val quantityRemaining: Double,
        @SerializedName("Commission") val commission: Double,
        @SerializedName("Price") val price: Double,
        @SerializedName("PricePerUnit") val pricePerUnit: Double,
        @SerializedName("ImmediateOrCancel") val immediateOrCancel: Boolean,
        @SerializedName("IsConditional") val isConditional: Boolean,
        @SerializedName("Condition") val condition: OpenOrder.Condition,
        @SerializedName("ConditionTarget") val conditionTarget: String?
)