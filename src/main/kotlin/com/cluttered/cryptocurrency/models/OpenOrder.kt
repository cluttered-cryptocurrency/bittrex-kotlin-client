package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime
import java.util.*

data class OpenOrder(
        @SerializedName("Uuid") val uuid: UUID,
        @SerializedName("OrderUuid") val orderUUID: UUID,
        @SerializedName("Exchange") val exchange: String,
        @SerializedName("OrderType") val orderType: String,
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("QuantityRemaining") val quantityRemaining: Double,
        @SerializedName("Limit") val limit: Double,
        @SerializedName("CommissionPaid") val commissionPaid: Double,
        @SerializedName("Price") val price: Double,
        @SerializedName("PricePerUnit") val pricePerUnit: Double,
        @SerializedName("Opened") val opened: ZonedDateTime,
        @SerializedName("Closed") val closed: ZonedDateTime,
        @SerializedName("CancelInitiated") val cancelInitiated: Boolean,
        @SerializedName("ImmediateOrCancel") val immediateOrCancel: Boolean,
        @SerializedName("IsConditional") val isConditional: Boolean,
        @SerializedName("Condition") val condition: String,
        @SerializedName("ConditionTarget") val conditionTarget: String
)