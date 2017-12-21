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

    enum class OrderType {
        BUY,
        SELL,
        BOTH;

        override fun toString(): String = super.toString().toLowerCase()
    }

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
    fun getTicker(@Query(MARKET) market: String): Observable<ApiResponse<Ticker>>

    @GET("$V1_PUBLIC/getmarketsummaries")
    fun getMarketSummaries(): Observable<ApiResponse<List<MarketSummary>>>

    @GET("$V1_PUBLIC/getmarketsummary")
    fun getMarketSummary(@Query(MARKET) market: String): Observable<ApiResponse<List<MarketSummary>>>

    @GET("$V1_PUBLIC/getorderbook")
    fun getBothOrderBook(@Query(MARKET) market: String, @Query("type") type: OrderType = OrderType.BOTH): Observable<ApiResponse<OrderLists>>

    @GET("$V1_PUBLIC/getorderbook")
    fun getBuyOrderBook(@Query(MARKET) market: String, @Query("type") type: OrderType = OrderType.BUY): Observable<ApiResponse<List<Order>>>

    @GET("$V1_PUBLIC/getorderbook")
    fun getSellOrderBook(@Query(MARKET) market: String, @Query("type") type: OrderType = OrderType.SELL): Observable<ApiResponse<List<Order>>>
}