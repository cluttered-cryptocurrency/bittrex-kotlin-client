package com.cluttered.cryptocurrency

import io.reactivex.Observable

object Main {

    private val bittrexClient = PublicBittrexClient()

    @JvmStatic
    fun main(args: Array<String>) {

        // List Markets
        println("################ Markets ################")
        bittrexClient.public.getMarkets()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // List Currencies
        println("\n\n################ Currencies ################")
        bittrexClient.public.getCurrencies()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // Current Tick
        println("\n\n################ BTC-ETH Tick ################")
        bittrexClient.public.getTicker("BTC-ETH")
                .filter { it.success }
                .subscribe { println(it.result) }

        // List 24 hour Market Summaries
        println("\n\n################ Market Summaries ################")
        bittrexClient.public.getMarketSummaries()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }
    }
}