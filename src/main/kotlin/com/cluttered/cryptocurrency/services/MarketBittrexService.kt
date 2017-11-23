package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.credentials.ApiSignInterceptor.Companion.API_KEY
import com.cluttered.cryptocurrency.models.ApiListResponse
import com.cluttered.cryptocurrency.models.ApiResponse
import com.cluttered.cryptocurrency.models.OpenOrder
import com.cluttered.cryptocurrency.models.UuidResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MarketBittrexService {

    companion object {
        private const val MARKET: String = "market"

        const val V1_1_MARKET: String = "v1.1/$MARKET"
    }

    @GET("$V1_1_MARKET/buylimit")
    fun buyLimit(@Query(API_KEY) key: String, @Query(MARKET) market: String,
                    @Query("quantity") quantity: Double, @Query("rate") rate: Double)
            : Observable<ApiResponse<UuidResponse>>

    @GET("$V1_1_MARKET/selllimit")
    fun sellLimit(@Query(API_KEY) key: String, @Query(MARKET) market: String,
                 @Query("quantity") quantity: Double, @Query("rate") rate: Double)
            : Observable<ApiResponse<UuidResponse>>

    @GET("$V1_1_MARKET/cancel")
    fun cancel(@Query(API_KEY) key: String, @Query("uuid") uuid: UUID): Observable<ApiResponse<UuidResponse>>

    @GET("$V1_1_MARKET/getopenorders")
    fun getOpenOrders(@Query(API_KEY) key: String, @Query(MARKET) market: String)
            : Observable<ApiListResponse<OpenOrder>>
}