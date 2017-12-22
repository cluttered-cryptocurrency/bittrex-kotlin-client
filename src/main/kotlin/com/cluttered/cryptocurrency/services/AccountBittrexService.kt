package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.model.ApiResponse
import com.cluttered.cryptocurrency.model.Balance
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET

interface AccountBittrexService {

    companion object {
        const val V1_ACCOUNT = "v1.1/account"

        fun create(retrofit: Retrofit): AccountBittrexService {
            return retrofit.create(AccountBittrexService::class.java)
        }
    }

    @GET("$V1_ACCOUNT/getbalances")
    fun getBalances(): Observable<ApiResponse<List<Balance>>>
}