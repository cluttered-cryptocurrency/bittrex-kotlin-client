package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.services.PublicBittrexService
import io.reactivex.Observable

object Main {

    private val publicBittrexService by lazy {
        PublicBittrexService.create()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        publicBittrexService.getMarkets()
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.marketName == "BTC-ETH" }
                .subscribe { println(it.marketName) }
    }
}