package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.credentials.ApiSignInterceptor
import com.cluttered.cryptocurrency.models.*
import com.cluttered.cryptocurrency.models.Currency
import com.cluttered.cryptocurrency.serializers.DateDeserializer
import com.cluttered.cryptocurrency.services.PublicBittrexService
import com.cluttered.cryptocurrency.types.OrderType
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

open class BittrexClient {

    companion object {
        const val BITTREX_API_URL: String = "https://bittrex.com/api/"
    }

    private val publicService: PublicBittrexService

    protected val retrofit: Retrofit

    init {
        val gson = GsonBuilder()
                .setLenient()
                .registerTypeAdapter(Date::class.java, DateDeserializer())
                .create()

        val okHttpClientBuilder = OkHttpClient.Builder()
                .addNetworkInterceptor(ApiSignInterceptor())

        retrofit = Retrofit.Builder()
                .baseUrl(BITTREX_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()

        publicService = retrofit.create(PublicBittrexService::class.java)
    }

    fun getMarkets(): Observable<ApiListResponse<Market>> = publicService.getMarkets()

    fun getCurrencies(): Observable<ApiListResponse<Currency>> = publicService.getCurrencies()

    fun getTicker(market: String): Observable<ApiResponse<Ticker>> = publicService.getTicker(market)

    fun getMarketSummaries(): Observable<ApiListResponse<MarketSummary>> = publicService.getMarketSummaries()

    fun getMarketSummary(market: String): Observable<ApiListResponse<MarketSummary>> =
            publicService.getMarketSummary(market)

    fun getOrderBook(market: String, type: OrderType): Observable<ApiResponse<OrdersByType>> =
            publicService.getOrderBook(market, type)

    fun getMarketHistory(market: String): Observable<ApiListResponse<Trade>> =
            publicService.getMarketHistory(market)
}