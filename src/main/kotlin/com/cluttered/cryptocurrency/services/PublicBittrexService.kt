package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.models.*
import com.cluttered.cryptocurrency.types.OrderType
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PublicBittrexService {

    companion object {
        const val V1_1_PUBLIC: String = "v1.1/public"
    }

    @GET("$V1_1_PUBLIC/getmarkets")
    fun getMarkets(): Observable<ApiResponse<List<Market>>>

    @GET("$V1_1_PUBLIC/getcurrencies")
    fun getCurrencies(): Observable<ApiResponse<List<Currency>>>

    @GET("$V1_1_PUBLIC/getticker")
    fun getTicker(@Query("market") market: String): Observable<ApiResponse<Ticker>>

    @GET("$V1_1_PUBLIC/getmarketsummaries")
    fun getMarketSummaries(): Observable<ApiResponse<List<MarketSummary>>>

    @GET("$V1_1_PUBLIC/getmarketsummary")
    fun getMarketSummary(@Query("market") market: String): Observable<ApiResponse<List<MarketSummary>>>

    @GET("$V1_1_PUBLIC/getorderbook")
    fun getOrderBook(@Query("market") market: String, @Query("type") type: OrderType): Observable<ApiResponse<OrdersByType>>

    @GET("$V1_1_PUBLIC/getmarkethistory")
    fun getMarketHistory(@Query("market") market: String): Observable<ApiResponse<List<Trade>>>
}