# Bittrex Kotlin Client

[![Build Status](https://travis-ci.org/cluttered-cryptocurrency/bittrex-kotlin-client.svg?branch=master)](https://travis-ci.org/cluttered-cryptocurrency/bittrex-kotlin-client)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/15e3e33b590d42d2a73955c33a90ff9a)](https://www.codacy.com/app/cluttered-code/bittrex-kotlin-client?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=cluttered-cryptocurrency/bittrex-kotlin-client&amp;utm_campaign=Badge_Grade)
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

## Donations
* BTC: **1BcPBLKspsJ4uD1oQH46Xo4zUU5BicvYaT**
* ETH: **0x6d8770cd2fb3233acf30d8ff48b35f912b05b151**
* LTC: **LhpEZm9iufnpQZ9qTWH8BhLCjPVL6VhCog**