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
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // List Open Orders on Market
        println("\n\n################ BTC-ETH OpenOrders ################")
        bittrexClient.market.getOpenOrders("BTC-ETH")
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // List Markets
        println("\n\n################ Markets ################")
        bittrexClient.public.getMarkets()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // List Balances
        println("\n\n################ Balances ################")
        bittrexClient.account.getBalances()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // Deposit Address
        println("\n\n################ Deposit Address ################")
        bittrexClient.account.getDepositAddress("BTC")
                .filter { it.success }
                .subscribe { println(it.result.address) }

        // Deposit Address
        println("\n\n################ Socket ################")
        bittrexClient.socket.start(Runnable {
            println("Websocket started")
        })

        Thread.sleep(10000)
    }
}