package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.time.Instant
import java.util.*

data class AccountOrder(
        @SerializedName("OrderUuid") val orderUuid: UUID,
        @SerializedName("Exchange") val exchange: String,
        @SerializedName("Type") val orderType: OpenOrder.OrderType,
        @SerializedName("Quantity") val quantity: BigDecimal,
        @SerializedName("QuantityRemaining") val quantityRemaining: BigDecimal,
        @SerializedName("Limit") val limit: BigDecimal,
        @SerializedName("Reserved") val reserved: BigDecimal,
        @SerializedName("ReserveRemaining") val reserveRemaining: BigDecimal,
        @SerializedName("CommissionReserved") val commissionReserved: BigDecimal,
        @SerializedName("CommissionReserveRemaining") val commissionReserveRemaining: BigDecimal,
        @SerializedName("CommissionPaid") val commissionPaid: BigDecimal,
        @SerializedName("Price") val price: BigDecimal,
        @SerializedName("PricePerUnit") val pricePerUnit: BigDecimal,
        @SerializedName("Opened") val opened: Instant,
        @SerializedName("Closed") val closed: Instant?,
        @SerializedName("IsOpen") val isOpen: Boolean,
        @SerializedName("Sentinel") val sentinel: UUID,
        @SerializedName("CancelInitiated") val cancelInitiated: Boolean,
        @SerializedName("ImmediateOrCancel") val immediateOrCancel: Boolean,
        @SerializedName("IsConditional") val isConditional: Boolean,
        @SerializedName("Condition") val condition: OpenOrder.Condition,
        @SerializedName("ConditionTarget") val conditionTarget: String?
)
