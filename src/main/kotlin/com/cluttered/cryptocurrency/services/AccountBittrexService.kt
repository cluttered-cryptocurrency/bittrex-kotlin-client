package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.credentials.ApiSignInterceptor.Companion.API_KEY
import com.cluttered.cryptocurrency.models.ApiListResponse
import com.cluttered.cryptocurrency.models.ApiResponse
import com.cluttered.cryptocurrency.models.Balance
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface AccountBittrexService {

    companion object {
        const val V1_1_ACCOUNT: String = "v1.1/account/"
    }

    @GET(V1_1_ACCOUNT + "getbalances")
    fun getBalances(@Query(API_KEY) key: String): Observable<ApiListResponse<Balance>>

    @GET(V1_1_ACCOUNT + "getbalance")
    fun getBalance(@Query(API_KEY) key: String, @Query("currency") currency: String): Observable<ApiResponse<Balance>>

}