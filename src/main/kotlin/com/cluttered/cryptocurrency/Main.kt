package com.cluttered.cryptocurrency

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

    @JvmStatic
    fun main(args: Array<String>) {

        BittrexClient.getMarkets()
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.marketName == "BTC-ETH" }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }

        BittrexClient.getCurrencies()
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.currency == "ETH" }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }

        BittrexClient.getTicker("BTC-ETH")
                .map { it.result }
                .map { GSON.toJson(it) }
                .subscribe { println(it) }
    }
}