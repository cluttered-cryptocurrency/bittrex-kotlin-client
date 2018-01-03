package com.cluttered.cryptocurrency.examples

import com.cluttered.cryptocurrency.BittrexClient
import io.reactivex.Observable

object BittrexClientExample {

    private val bittrexClient = BittrexClient(
            "d1caaed14e7d427488445a4e02a4760f",
            "38660a5c5b7341efae27799e991b4c0b")

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
    }
}