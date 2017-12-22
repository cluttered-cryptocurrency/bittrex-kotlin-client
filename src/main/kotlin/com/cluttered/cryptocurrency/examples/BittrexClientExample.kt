package com.cluttered.cryptocurrency.examples

import com.cluttered.cryptocurrency.BittrexClient
import io.reactivex.Observable

object BittrexClientExample {

    private val bittrexClient = BittrexClient(
            "YOUR KEY",
            "YOUR SECRET")

    @JvmStatic
    fun main(args: Array<String>) {
        bittrexClient.market.getOpenOrders()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }


        bittrexClient.market.getOpenOrders("BTC-ETH")
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        bittrexClient.public.getMarkets()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        bittrexClient.account.getBalances()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }
    }
}