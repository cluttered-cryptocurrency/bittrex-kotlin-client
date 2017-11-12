package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.models.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PublicBittrexService {

    @GET("v1.1/public/getmarkets")
    fun getMarkets(): Observable<ApiListResponse<Market>>

    @GET("v1.1/public/getcurrencies")
    fun getCurrencies(): Observable<ApiListResponse<Currency>>

    @GET("v1.1/public/getticker")
    fun getTicker(@Query("market") market: String): Observable<ApiResponse<Ticker>>

    @GET("v1.1/public/getmarketsummaries ")
    fun getMarketSummaries(): Observable<ApiListResponse<MarketSummary>>
}