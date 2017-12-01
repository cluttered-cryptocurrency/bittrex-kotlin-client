package com.cluttered.cryptocurrency.models

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime
import java.util.*

data class Order(
        @SerializedName("AccountId") val accountId: String,
        @SerializedName("OrderUuid") val orderUUID: UUID,
        @SerializedName("Exchange") val exchange: String,
        @SerializedName("Type") val type: String,
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
        @SerializedName("Condition") val condition: String,
        @SerializedName("ConditionTarget") val conditionTarget: String?
)