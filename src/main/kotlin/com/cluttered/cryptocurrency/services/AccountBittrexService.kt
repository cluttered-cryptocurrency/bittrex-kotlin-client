package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.models.ApiListResponse
import com.cluttered.cryptocurrency.models.Balance
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface AccountBittrexService {

    companion object {
        const val V1_1_ACCOUNT: String = "v1.1/account/"
    }

    @GET(V1_1_ACCOUNT + "getbalances")
    fun getBalances(@Query("apikey") key: String): Observable<ApiListResponse<Balance>>

}