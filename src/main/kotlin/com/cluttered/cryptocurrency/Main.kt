package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.types.OrderType
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Observable

object Main {

    private val GSON: Gson = GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .serializeNulls()
            .setPrettyPrinting()
            .create()

    private val bittrexClient: BittrexClient = BittrexClient()

    @JvmStatic
    fun main(args: Array<String>) {

        bittrexClient.getMarkets()
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.marketName == "BTC-ETH" }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }

        bittrexClient.getCurrencies()
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.currency == "ETH" }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }

        bittrexClient.getTicker("BTC-ETH")
                .map { it.result }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }

        bittrexClient.getMarketSummaries()
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.marketName == "BTC-ETH" }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }

        bittrexClient.getMarketSummary("BTC-ETH")
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }

        bittrexClient.getOrderBook("BTC-ETH", OrderType.BOTH)
                .map { it.result }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }

        bittrexClient.getMarketHistory("BTC-ETH")
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }
    }
}