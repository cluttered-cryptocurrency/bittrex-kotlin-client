package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.model.*
import com.cluttered.cryptocurrency.retrofit.RetrofitFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface PublicBittrexService {

    companion object {
        const val V1_PUBLIC: String = "v1.1/public"
        const val MARKET: String = "market"

        fun create() = create(RetrofitFactory.create())

        fun create(retrofit: Retrofit): PublicBittrexService {
            return retrofit.create(PublicBittrexService::class.java)
        }
    }

    @GET("$V1_PUBLIC/getmarkets")
    fun getMarkets(): Observable<ApiResponse<MutableList<Market>>>

    @GET("$V1_PUBLIC/getcurrencies")
    fun getCurrencies(): Observable<ApiResponse<MutableList<Currency>>>

    @GET("$V1_PUBLIC/getticker")
    fun getTicker(@Query(MARKET) market: String): Observable<ApiResponse<Ticker>>

    @GET("$V1_PUBLIC/getmarketsummaries")
    fun getMarketSummaries(): Observable<ApiResponse<MutableList<MarketSummary>>>

    @GET("$V1_PUBLIC/getmarketsummary")
    fun getMarketSummary(@Query(MARKET) market: String): Observable<ApiResponse<MutableList<MarketSummary>>>

    @GET("$V1_PUBLIC/getorderbook?type=both")
    fun getOrderBook(@Query(MARKET) market: String): Observable<ApiResponse<OrderLists>>

    @GET("$V1_PUBLIC/getorderbook?type=buy")
    fun getBuyOrderBook(@Query(MARKET) market: String): Observable<ApiResponse<MutableList<Order>>>

    @GET("$V1_PUBLIC/getorderbook?type=sell")
    fun getSellOrderBook(@Query(MARKET) market: String): Observable<ApiResponse<MutableList<Order>>>

    @GET("$V1_PUBLIC/getmarkethistory")
    fun getMarketHistory(@Query(MARKET) market: String): Observable<ApiResponse<MutableList<MarketHistory>>>
}