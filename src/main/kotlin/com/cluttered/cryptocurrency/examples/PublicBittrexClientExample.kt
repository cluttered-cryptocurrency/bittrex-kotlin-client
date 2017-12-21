package com.cluttered.cryptocurrency.examples

import com.cluttered.cryptocurrency.PublicBittrexClient
import io.reactivex.Observable

object PublicBittrexClientExample {

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

        // Individual 24 hour Market Summary
        println("\n\n################ BTC-ETH Market Summaries ################")
        bittrexClient.public.getMarketSummary("BTC-ETH")
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .firstElement()
                .subscribe { println(it) }

        // Order Book
        println("\n\n################ BTC-ETH Order Book ################")
        val orderBookObservable = bittrexClient.public.getOrderBook("BTC-ETH")
                .filter { it.success }
                .map { it.result }
        orderBookObservable.flatMap { Observable.fromIterable(it.buy) }
                .subscribe { println("Buy - $it") }
        orderBookObservable.flatMap { Observable.fromIterable(it.sell) }
                .subscribe { println("Sell - $it") }

        // Buy Order Book
        println("\n\n################ BTC-ETH Buy Order Book ################")
        bittrexClient.public.getBuyOrderBook("BTC-ETH")
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // Sell Order Book
        println("\n\n################ BTC-ETH Sell Order Book ################")
        bittrexClient.public.getSellOrderBook("BTC-ETH")
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // Market History
        println("\n\n################ BTC-ETH Market History ################")
        bittrexClient.public.getMarketHistory("BTC-ETH")
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }
    }
}