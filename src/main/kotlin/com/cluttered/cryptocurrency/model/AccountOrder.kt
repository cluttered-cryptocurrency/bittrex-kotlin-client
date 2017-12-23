package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime
import java.util.*

data class AccountOrder(
        @SerializedName("OrderUuid") val orderUuid: UUID,
        @SerializedName("Exchange") val exchange: String,
        @SerializedName("Type") val orderType: OpenOrder.OrderType,
        @SerializedName("Quantity") val quantity: Double,
        @SerializedName("QuantityRemaining") val quantityRemaining: Double,
        @SerializedName("Limit") val limit: Double,
        @SerializedName("Reserved") val reserved: Double,
        @SerializedName("ReserveRemaining") val reserveRemaining: Double,
        @SerializedName("CommissionReserved") val commissionReserved: Double,
        @SerializedName("CommissionReserveRemaining") val commissionReserveRemaining: Double,
        @SerializedName("CommissionPaid") val commissionPaid: Double,
        @SerializedName("Price") val price: Double,
        @SerializedName("PricePerUnit") val pricePerUnit: Double,
        @SerializedName("Opened") val opened: ZonedDateTime,
        @SerializedName("Closed") val closed: ZonedDateTime?,
        @SerializedName("IsOpen") val isOpen: Boolean,
        @SerializedName("Sentinel") val sentinel: UUID,
        @SerializedName("CancelInitiated") val cancelInitiated: Boolean,
        @SerializedName("ImmediateOrCancel") val immediateOrCancel: Boolean,
        @SerializedName("IsConditional") val isConditional: Boolean,
        @SerializedName("Condition") val condition: OpenOrder.Condition,
        @SerializedName("ConditionTarget") val conditionTarget: String?
)
