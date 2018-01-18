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
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println("Markets: $it") }

        // List Currencies
        println("\n\n################ Currencies ################")
        bittrexClient.public.getCurrencies()
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println("Currencies: $it") }

        // Current Ticker
        println("\n\n################ BTC-ETH Ticker ################")
        bittrexClient.public.getTicker("BTC-ETH")
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .subscribe { println("Ticker: ${it.result}") }

        // List 24 hour Market Summaries
        println("\n\n################ Market Summaries ################")
        bittrexClient.public.getMarketSummaries()
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println("Market Summaries: $it") }

        // Individual 24 hour Market Summary
        println("\n\n################ BTC-ETH Market Summaries ################")
        bittrexClient.public.getMarketSummary("BTC-ETH")
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .flatMap { Observable.fromIterable(it.result) }
                .firstElement()
                .subscribe { println(it) }

        // Order Book
        println("\n\n################ BTC-ETH Order Book ################")
        val orderBookObservable = bittrexClient.public.getOrderBook("BTC-ETH")
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .map { it.result }
        orderBookObservable.flatMap { Observable.fromIterable(it.buy) }
                .subscribe { println("Buy - $it") }
        orderBookObservable.flatMap { Observable.fromIterable(it.sell) }
                .subscribe { println("Sell - $it") }

        // Buy Order Book
        println("\n\n################ BTC-ETH Buy Order Book ################")
        bittrexClient.public.getBuyOrderBook("BTC-ETH")
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // Sell Order Book
        println("\n\n################ BTC-ETH Sell Order Book ################")
        bittrexClient.public.getSellOrderBook("BTC-ETH")
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }

        // Market History
        println("\n\n################ BTC-ETH Market History ################")
        bittrexClient.public.getMarketHistory("BTC-ETH")
                .doOnError { println("Bittrex Exception: ${it.message}") }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }
    }
}