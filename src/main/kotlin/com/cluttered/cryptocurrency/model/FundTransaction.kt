package com.cluttered.cryptocurrency.model

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime
import java.util.*

data class FundTransaction(
        @SerializedName("PaymentUuid") val paymentUuid: UUID,
        @SerializedName("Currency") val currency: String,
        @SerializedName("Amount") val amount: Double,
        @SerializedName("Address") val address: String,
        @SerializedName("Opened") val opened: ZonedDateTime,
        @SerializedName("Authorized") val authorized: Boolean,
        @SerializedName("PendingPayment") val pendingPayment: Boolean,
        @SerializedName("TxCost") val txCost: Double,
        @SerializedName("TxId") val txId: String,
        @SerializedName("Canceled") val canceled: Boolean,
        @SerializedName("InvalidAddress") val invalidAddress: Boolean
)