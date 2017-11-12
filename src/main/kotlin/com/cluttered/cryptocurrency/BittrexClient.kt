package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.marshal.DateDeserializer
import com.cluttered.cryptocurrency.models.*
import com.cluttered.cryptocurrency.models.Currency
import com.cluttered.cryptocurrency.services.PublicBittrexService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object BittrexClient : PublicBittrexService {

    private val BITTREX_API_URL: String = "https://bittrex.com/api/"

    private val GSON: Gson = GsonBuilder()
            .setLenient()
            .registerTypeAdapter(Date::class.java, DateDeserializer())
            .create()

    private val retrofit = Retrofit.Builder()
            .baseUrl(BITTREX_API_URL)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private val publicService = retrofit.create(PublicBittrexService::class.java)

    override fun getMarkets(): Observable<ApiListResponse<Market>> {
        return publicService.getMarkets()
    }

    override fun getCurrencies(): Observable<ApiListResponse<Currency>> {
        return publicService.getCurrencies()
    }

    override fun getTicker(market: String): Observable<ApiResponse<Ticker>> {
        return publicService.getTicker(market)
    }

    override fun getMarketSummaries(): Observable<ApiListResponse<MarketSummary>> {
        return publicService.getMarketSummaries()
    }

    override fun getMarketSummary(market: String): Observable<ApiListResponse<MarketSummary>> {
        return publicService.getMarketSummary(market)
    }

    override fun getOrderBook(market: String, type: OrderType): Observable<ApiResponse<OrdersByType>> {
        return publicService.getOrderBook(market, type)
    }
}