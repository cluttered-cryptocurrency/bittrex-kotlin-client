package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.model.*
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface AccountBittrexService {

    companion object {
        const val V1_ACCOUNT = "v1.1/account"
        const val CURRENCY = "currency"

        fun create(retrofit: Retrofit): AccountBittrexService {
            return retrofit.create(AccountBittrexService::class.java)
        }
    }

    @GET("$V1_ACCOUNT/getbalances")
    fun getBalances(): Observable<ApiResponse<List<Balance>>>

    @GET("$V1_ACCOUNT/getbalance")
    fun getBalance(@Query(CURRENCY) currency: String): Observable<ApiResponse<Balance>>

    @GET("$V1_ACCOUNT/getdepositaddress")
    fun getDepositAddress(@Query(CURRENCY) currency: String): Observable<ApiResponse<DepositAddress>>

    @GET("$V1_ACCOUNT/withdraw")
    fun withdraw(@Query(CURRENCY) currency: String,
                 @Query("quantity") quantity: Double,
                 @Query("address") address: String,
                 @Query("paymentid") paymentId: String = ""):
            Observable<ApiResponse<UuidResponse>>

    @GET("$V1_ACCOUNT/getorder")
    fun getOrder(@Query("uuid") uuid: UUID): Observable<ApiResponse<List<AccountOrder>>>
}