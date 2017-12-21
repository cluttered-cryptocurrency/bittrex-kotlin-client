package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.marshallers.ZonedDateTimeDeserializer
import com.cluttered.cryptocurrency.model.*
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.ZonedDateTime

interface PublicBittrexService {

    companion object {
        const val V1_PUBLIC: String = "v1.1/public"
        const val MARKET: String = "market"

        fun create(): PublicBittrexService {
            val gson = GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeDeserializer())
                    .serializeNulls()
                    .create()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl("https://bittrex.com/api/")
                    .build()

            return create(retrofit)
        }

        fun create(retrofit: Retrofit): PublicBittrexService {
            return retrofit.create(PublicBittrexService::class.java)
        }
    }

    @GET("$V1_PUBLIC/getmarkets")
    fun getMarkets(): Observable<ApiResponse<List<Market>>>

    @GET("$V1_PUBLIC/getcurrencies")
    fun getCurrencies(): Observable<ApiResponse<List<Currency>>>

    @GET("$V1_PUBLIC/getticker")
    fun getTicker(@Query(MARKET) market: String): Observable<ApiResponse<Tick>>

    @GET("$V1_PUBLIC/getmarketsummaries")
    fun getMarketSummaries(): Observable<ApiResponse<List<MarketSummary>>>

    @GET("$V1_PUBLIC/getmarketsummary")
    fun getMarketSummary(@Query(MARKET) market: String): Observable<ApiResponse<List<MarketSummary>>>

    @GET("$V1_PUBLIC/getorderbook?type=both")
    fun getOrderBook(@Query(MARKET) market: String): Observable<ApiResponse<OrderLists>>

    @GET("$V1_PUBLIC/getorderbook?type=buy")
    fun getBuyOrderBook(@Query(MARKET) market: String): Observable<ApiResponse<List<Order>>>

    @GET("$V1_PUBLIC/getorderbook?type=sell")
    fun getSellOrderBook(@Query(MARKET) market: String): Observable<ApiResponse<List<Order>>>

    @GET("$V1_PUBLIC/getmarkethistory")
    fun getMarketHistory(@Query(MARKET) market: String): Observable<ApiResponse<List<MarketHistory>>>
}