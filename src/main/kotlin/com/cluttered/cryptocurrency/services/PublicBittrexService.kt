package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.models.ApiResponse
import com.cluttered.cryptocurrency.models.Currency
import com.cluttered.cryptocurrency.models.Market
import io.reactivex.Observable
import retrofit2.http.GET

interface PublicBittrexService {

    @GET("v1.1/public/getmarkets")
    fun getMarkets() : Observable<ApiResponse<Market>>

    @GET("v1.1/public/getcurrencies")
    fun getCurrencies() : Observable<ApiResponse<Currency>>
}