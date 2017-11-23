package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.credentials.Credentials
import com.cluttered.cryptocurrency.models.*
import com.cluttered.cryptocurrency.services.AccountBittrexService
import com.cluttered.cryptocurrency.services.MarketBittrexService
import io.reactivex.Observable
import java.util.*

class AuthorizedBittrexClient(key: String, secret: String) : BittrexClient() {

    private val accountService: AccountBittrexService = retrofit.create(AccountBittrexService::class.java)
    private val marketService: MarketBittrexService = retrofit.create(MarketBittrexService::class.java)
    
    init {
        Credentials.key = key
        Credentials.secret = secret
    }

    fun getBalances(): Observable<ApiListResponse<Balance>> = accountService.getBalances(Credentials.key)

    fun getBalance(currency: String): Observable<ApiResponse<Balance>> =
            accountService.getBalance(Credentials.key, currency)

    fun getDepositAddress(currency: String): Observable<ApiResponse<DepositAddress>> =
            accountService.getDepositAddress(Credentials.key, currency)

    fun withdraw(currency: String, quantity: Double, address: String, paymentid: String? = null)
            : Observable<ApiResponse<UuidResponse>> =
            accountService.withdraw(Credentials.key, currency, quantity, address, paymentid)

    fun getOrder(uuid: UUID): Observable<ApiResponse<Order>> = accountService.getOrder(Credentials.key, uuid)

    fun getOrderHistory(): Observable<ApiResponse<OrderHistory>> = accountService.getOrderhistory(Credentials.key)

    fun getWithdrawalHistory(currency: String): Observable<ApiResponse<WithdrawalHistory>> =
            accountService.getWithdrawalHistory(Credentials.key, currency)

    fun getDeposithistory(currency: String): Observable<ApiResponse<WithdrawalHistory>> =
            accountService.getDepositHistory(Credentials.key, currency)

    fun buyLimit(market: String, quantity: Double, rate: Double): Observable<ApiResponse<UuidResponse>> =
            marketService.buyLimit(Credentials.key, market, quantity, rate)

    fun sellLimit(market: String, quantity: Double, rate: Double): Observable<ApiResponse<UuidResponse>> =
            marketService.sellLimit(Credentials.key, market, quantity, rate)

    fun cancel(uuid: UUID): Observable<ApiResponse<UuidResponse>> = marketService.cancel(Credentials.key, uuid)

    fun getOpenOrders(market: String): Observable<ApiListResponse<OpenOrder>> =
            marketService.getOpenOrders(Credentials.key, market)
}