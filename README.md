# Bittrex Kotlin Client

[![Build Status](https://travis-ci.org/cluttered-cryptocurrency/bittrex-kotlin-client.svg?branch=master)](https://travis-ci.org/cluttered-cryptocurrency/bittrex-kotlin-client)
[![codecov](https://codecov.io/gh/cluttered-cryptocurrency/bittrex-kotlin-client/branch/master/graph/badge.svg)](https://codecov.io/gh/cluttered-cryptocurrency/bittrex-kotlin-client)
[![Jitpack](https://jitpack.io/v/cluttered-cryptocurrency/bittrex-kotlin-client.svg)](https://jitpack.io/#cluttered-cryptocurrency/bittrex-kotlin-client)

## Usage
```kotlin
object Main {

    private val bittrexClient = PublicBittrexClient()

    @JvmStatic
    fun main(args: Array<String>) {

        bittrexClient.public.getMarkets()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe { println(it) }
    }
}
```
[More Examples](https://github.com/cluttered-cryptocurrency/bittrex-kotlin-client/tree/master/src/main/kotlin/com/cluttered/cryptocurrency/examples)