package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.time.Instant
import java.util.*

data class OrderHistory(
        @SerializedName("OrderUuid") val orderUuid: UUID,
        @SerializedName("Exchange") val exchange: String,
        @SerializedName("TimeStamp") val timestamp: Instant,
        @SerializedName("OrderType") val orderType: OpenOrder.OrderType,
        @SerializedName("Limit") val limit: BigDecimal,
        @SerializedName("Quantity") val quantity: BigDecimal,
        @SerializedName("QuantityRemaining") val quantityRemaining: BigDecimal,
        @SerializedName("Commission") val commission: BigDecimal,
        @SerializedName("Price") val price: BigDecimal,
        @SerializedName("PricePerUnit") val pricePerUnit: BigDecimal,
        @SerializedName("ImmediateOrCancel") val immediateOrCancel: Boolean,
        @SerializedName("IsConditional") val isConditional: Boolean,
        @SerializedName("Condition") val condition: OpenOrder.Condition,
        @SerializedName("ConditionTarget") val conditionTarget: String?
)