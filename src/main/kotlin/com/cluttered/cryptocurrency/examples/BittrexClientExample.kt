package com.cluttered.cryptocurrency.examples

import com.cluttered.cryptocurrency.BittrexClient
import io.reactivex.Observable

object BittrexClientExample {

    private val key = "YOUR_API_KEY"
    private val secret = "YOUR_API_SECRET"
    private val bittrexClient = BittrexClient(key, secret)

    @JvmStatic
    fun main(args: Array<String>) {

        // List Open Orders
        println("\n\n################ OpenOrders ################")
        bittrexClient.market.getOpenOrders()
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe(
                        { println(it) },
                        { println("Bittrex Exception: ${it.message}") })

        // List Open Orders on Market
        println("\n\n################ BTC-ETH OpenOrders ################")
        bittrexClient.market.getOpenOrders("BTC-ETH")
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe(
                        { println(it) },
                        { println("Bittrex Exception: ${it.message}") })

        // List Markets
        println("\n\n################ Markets ################")
        bittrexClient.public.getMarkets()
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe(
                        { println(it) },
                        { println("Bittrex Exception: ${it.message}") })

        // List Balances
        println("\n\n################ Balances ################")
        bittrexClient.account.getBalances()
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe(
                        { println(it) },
                        { println("Bittrex Exception: ${it.message}") })

        // Deposit Address
        println("\n\n################ Deposit Address ################")
        bittrexClient.account.getDepositAddress("BTC")
                .subscribe(
                        { println(it.result.address) },
                        { println("Bittrex Exception: ${it.message}") })
    }
}