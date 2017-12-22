package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.model.ApiResponse
import com.cluttered.cryptocurrency.model.OpenOrder
import com.cluttered.cryptocurrency.model.UuidResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MarketBittrexService {

    companion object {
        const val MARKET = "market"
        const val V1_MARKET = "v1.1/$MARKET"
        const val QUANTITY = "quantity"
        const val RATE = "rate"

        fun create(retrofit: Retrofit): MarketBittrexService {
            return retrofit.create(MarketBittrexService::class.java)
        }
    }

    @GET("$V1_MARKET/buylimit")
    fun buyLimit(@Query(MARKET) market: String, @Query(QUANTITY) quantity: Double, @Query(RATE) rate: Double)
            : Observable<ApiResponse<UuidResponse>>

    @GET("$V1_MARKET/selllimit")
    fun sellLimit(@Query(MARKET) market: String, @Query(QUANTITY) quantity: Double, @Query(RATE) rate: Double)
            : Observable<ApiResponse<UuidResponse>>

    @GET("$V1_MARKET/cancel")
    fun cancel(@Query("uuid") uuid: UUID): Observable<ApiResponse<UUID>>

    @GET("$V1_MARKET/getopenorders")
    fun getOpenOrders(@Query(MARKET) market: String = ""): Observable<ApiResponse<List<OpenOrder>>>
}