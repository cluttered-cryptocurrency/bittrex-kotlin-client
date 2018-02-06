package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.model.ApiResponse
import com.cluttered.cryptocurrency.model.FundTransaction
import com.cluttered.cryptocurrency.model.OpenOrder
import com.cluttered.cryptocurrency.model.UuidResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigDecimal
import java.util.*

interface MarketBittrexService {

    companion object {
        const val CURRENCY = "currency"
        const val MARKET = "market"
        const val V1_MARKET = "v1.1/$MARKET"
        const val QUANTITY = "quantity"
        const val RATE = "rate"

        fun create(retrofit: Retrofit): MarketBittrexService {
            return retrofit.create(MarketBittrexService::class.java)
        }
    }

    @GET("$V1_MARKET/buylimit")
    fun buyLimit(@Query(MARKET) market: String, @Query(QUANTITY) quantity: BigDecimal, @Query(RATE) rate: BigDecimal)
            : Observable<ApiResponse<UuidResponse>>

    @GET("$V1_MARKET/selllimit")
    fun sellLimit(@Query(MARKET) market: String, @Query(QUANTITY) quantity: BigDecimal, @Query(RATE) rate: BigDecimal)
            : Observable<ApiResponse<UuidResponse>>

    @GET("$V1_MARKET/cancel")
    fun cancel(@Query("uuid") uuid: UUID): Observable<ApiResponse<UuidResponse>>

    @GET("$V1_MARKET/getopenorders")
    fun getOpenOrders(@Query(MARKET) market: String = ""): Observable<ApiResponse<MutableList<OpenOrder>>>

    @GET("$V1_MARKET/getwithdrawalhistory")
    fun getWithdrawalHistory(@Query(CURRENCY) currency: String = ""): Observable<ApiResponse<MutableList<FundTransaction>>>

    @GET("$V1_MARKET/getdeposithistory")
    fun getDepositHistory(@Query(CURRENCY) currency: String = ""): Observable<ApiResponse<MutableList<FundTransaction>>>
}