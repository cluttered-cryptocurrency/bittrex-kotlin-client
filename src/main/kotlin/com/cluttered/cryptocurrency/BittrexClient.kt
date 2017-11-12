package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.models.ApiResponse
import com.cluttered.cryptocurrency.models.Currency
import com.cluttered.cryptocurrency.models.Market
import com.cluttered.cryptocurrency.services.PublicBittrexService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object BittrexClient : PublicBittrexService {

    private val BITTREX_API_URL : String = "https://bittrex.com/api/"

    private val GSON : Gson = GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()

    //Create retrofit, set the API base URL and GSonConverterFactory
    private val retrofit = Retrofit.Builder()
            .baseUrl(BITTREX_API_URL)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private val publicService = retrofit.create(PublicBittrexService::class.java)

    override fun getMarkets(): Observable<ApiResponse<Market>>  {
        return publicService.getMarkets()
    }

    override fun getCurrencies(): Observable<ApiResponse<Currency>>  {
        return publicService.getCurrencies()
    }
}