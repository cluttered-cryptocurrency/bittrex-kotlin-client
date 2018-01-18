# Bittrex Kotlin Client

[![Build Status](https://travis-ci.org/cluttered-cryptocurrency/bittrex-kotlin-client.svg?branch=master)](https://travis-ci.org/cluttered-cryptocurrency/bittrex-kotlin-client)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/15e3e33b590d42d2a73955c33a90ff9a)](https://www.codacy.com/app/cluttered-code/bittrex-kotlin-client?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=cluttered-cryptocurrency/bittrex-kotlin-client&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/cluttered-cryptocurrency/bittrex-kotlin-client/branch/master/graph/badge.svg)](https://codecov.io/gh/cluttered-cryptocurrency/bittrex-kotlin-client)
[![Jitpack](https://jitpack.io/v/cluttered-cryptocurrency/bittrex-kotlin-client.svg)](https://jitpack.io/#cluttered-cryptocurrency/bittrex-kotlin-client)

![Donate Bitcoin](https://img.shields.io/badge/Donate_Bitcoin-1BcPBLKspsJ4uD1oQH46Xo4zUU5BicvYaT-yellow.svg)

## Usage

### Public
```kotlin
object Main {

    private val bittrexClient = PublicBittrexClient()

    @JvmStatic
    fun main(args: Array<String>) {

        // List Markets
        bittrexClient.public.getMarkets()
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe(
                        { println(it) },
                        { println("Bittrex Exception: ${it.message}") })
    }
}
```

### Secure
```kotlin
object Main {

    private val key = "YOUR_API_KEY"
    private val secret = "YOUR_API_SECRET"
    private val bittrexClient = BittrexClient(key, secret)

    @JvmStatic
    fun main(args: Array<String>) {

        // List Account Balances
        bittrexClient.account.getBalances()
                .flatMap { Observable.fromIterable(it.result) }
                .subscribe(
                        { println(it) },
                        { println("Bittrex Exception: ${it.message}") })
    }
}
```

#### [More Examples](https://github.com/cluttered-cryptocurrency/bittrex-kotlin-client/tree/master/src/main/kotlin/com/cluttered/cryptocurrency/examples)

## Import

### Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'com.github.cluttered-cryptocurrency:bittrex-kotlin-client:2.3.0'
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.cluttered-cryptocurrency</groupId>
    <artifactId>bittrex-kotlin-client</artifactId>
    <version>2.3.0</version>
</dependency>
```

## Donation

### Bitcoin
![1BcPBLKspsJ4uD1oQH46Xo4zUU5BicvYaT](https://raw.githubusercontent.com/cluttered-cryptocurrency/bittrex-kotlin-client/master/qr-codes/bitcoin-qr-1BcPBLKspsJ4uD1oQH46Xo4zUU5BicvYaT.png)

**1BcPBLKspsJ4uD1oQH46Xo4zUU5BicvYaT**