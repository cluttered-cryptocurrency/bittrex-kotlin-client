# bittrex-kotlin-client

[![Build Status](https://travis-ci.org/cluttered-cryptocurrency/bittrex-kotlin-client.svg?branch=master)](https://travis-ci.org/cluttered-cryptocurrency/bittrex-kotlin-client)
[![codecov](https://codecov.io/gh/cluttered-cryptocurrency/bittrex-kotlin-client/branch/master/graph/badge.svg)](https://codecov.io/gh/cluttered-cryptocurrency/bittrex-kotlin-client)
[![Jitpack](https://jitpack.io/v/cluttered-cryptocurrency/bittrex-kotlin-client.svg)](https://jitpack.io/#cluttered-cryptocurrency/bittrex-kotlin-client)


## Usage
```kotlin
object Main {

    private val publicBittrexService by lazy {
        PublicBittrexService.create()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        publicBittrexService.getMarkets()
                .filter { it.success }
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.marketName == "BTC-ETH" }
                .subscribe { println(it.marketName) }
    }
}
```