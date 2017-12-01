package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.credentials.ApiSignInterceptor
import com.cluttered.cryptocurrency.models.*
import com.cluttered.cryptocurrency.models.Currency
import com.cluttered.cryptocurrency.marshallers.ZonedDateTimeMarshaller
import com.cluttered.cryptocurrency.services.PublicBittrexService
import com.cluttered.cryptocurrency.types.OrderType
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.time.ZonedDateTime

open class BittrexClient {

    companion object {
        const val BITTREX_API_URL: String = "https://bittrex.com/api/"
    }

    private val publicService: PublicBittrexService

    protected val retrofit: Retrofit

    init {
        val gson = GsonBuilder()
                .setLenient()
                .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeMarshaller())
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

    fun getMarkets(): Observable<ApiResponse<List<Market>>> = publicService.getMarkets()

    fun getCurrencies(): Observable<ApiResponse<List<Currency>>> = publicService.getCurrencies()

    fun getTicker(market: String): Observable<ApiResponse<Ticker>> = publicService.getTicker(market)

    fun getMarketSummaries(): Observable<ApiResponse<List<MarketSummary>>> = publicService.getMarketSummaries()

    fun getMarketSummary(market: String): Observable<ApiResponse<List<MarketSummary>>> =
            publicService.getMarketSummary(market)

    fun getOrderBook(market: String, type: OrderType): Observable<ApiResponse<OrdersByType>> =
            publicService.getOrderBook(market, type)

    fun getMarketHistory(market: String): Observable<ApiResponse<List<Trade>>> =
            publicService.getMarketHistory(market)
}