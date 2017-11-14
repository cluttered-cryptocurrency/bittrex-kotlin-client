package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.credentials.ApiSignInterceptor
import com.cluttered.cryptocurrency.credentials.Credentials
import com.cluttered.cryptocurrency.models.*
import com.cluttered.cryptocurrency.models.Currency
import com.cluttered.cryptocurrency.serializers.DateDeserializer
import com.cluttered.cryptocurrency.services.AccountBittrexService
import com.cluttered.cryptocurrency.services.PublicBittrexService
import com.cluttered.cryptocurrency.types.OrderType
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyException
import java.util.*

class BittrexClient(private val key: String? = null, private val secret: String? = null) : PublicBittrexService {

    private val BITTREX_API_URL: String = "https://bittrex.com/api/"

    private val publicService: PublicBittrexService
    private val accountService: AccountBittrexService

    init {
        Credentials.key = this.key
        Credentials.secret = this.secret

        val gson = GsonBuilder()
                .setLenient()
                .registerTypeAdapter(Date::class.java, DateDeserializer())
                .create()

        val okHttpClientBuilder = OkHttpClient.Builder()
                .addNetworkInterceptor(ApiSignInterceptor())

        val retrofit = Retrofit.Builder()
                .baseUrl(BITTREX_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()

        publicService = retrofit.create(PublicBittrexService::class.java)
        accountService = retrofit.create(AccountBittrexService::class.java)
    }

    override fun getMarkets(): Observable<ApiListResponse<Market>> = publicService.getMarkets()

    override fun getCurrencies(): Observable<ApiListResponse<Currency>> = publicService.getCurrencies()

    override fun getTicker(market: String): Observable<ApiResponse<Ticker>> = publicService.getTicker(market)

    override fun getMarketSummaries(): Observable<ApiListResponse<MarketSummary>> = publicService.getMarketSummaries()

    override fun getMarketSummary(market: String): Observable<ApiListResponse<MarketSummary>> =
            publicService.getMarketSummary(market)

    override fun getOrderBook(market: String, type: OrderType): Observable<ApiResponse<OrdersByType>> =
            publicService.getOrderBook(market, type)

    override fun getMarketHistory(market: String): Observable<ApiListResponse<Trade>> =
            publicService.getMarketHistory(market)

    fun getBalances(): Observable<ApiListResponse<Balance>> {
        credentialsPresent()
        return accountService.getBalances(Credentials.key!!)
    }

    private fun credentialsPresent() {
        if (Credentials.key == null || Credentials.secret == null)
            throw KeyException("missing 'key' or 'secret' credentials")
    }
}