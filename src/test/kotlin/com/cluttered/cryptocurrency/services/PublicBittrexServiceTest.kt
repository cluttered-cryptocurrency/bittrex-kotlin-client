package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.model.Ticker
import io.reactivex.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PublicBittrexServiceTest {

    private val publicBittrexService by lazy {
        PublicBittrexService.create()
    }

    @Test
    fun testBtcEthMarket() {
        val expectedMarketName = "BTC-ETH"
        var result = ""
        publicBittrexService.getMarkets()
                .filter { it.success }
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.marketName == expectedMarketName }
                .subscribe {
                    result = it.marketName
                    println(it)
                }

        assertThat(result).isEqualTo(expectedMarketName)
    }

    @Test
    fun testLtcCurrency() {
        val expectedCurrency = "LTC"
        var result = ""
        publicBittrexService.getCurrencies()
                .filter { it.success }
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.currency == expectedCurrency }
                .subscribe {
                    result = it.currency
                    println(it)
                }

        assertThat(result).isEqualTo(expectedCurrency)
    }

    @Test
    fun testArdrTicker() {
        val market = "BTC-ARDR"
        var result = Ticker(0.0,0.0,0.0)
        publicBittrexService.getTicker(market)
                .filter { it.success }
                .map { it.result }
                .subscribe {
                    result = it
                    println("$market: $it")
                }

        assertThat(result.ask).isGreaterThan(0.0)
        assertThat(result.bid).isGreaterThan(0.0)
        assertThat(result.last).isGreaterThan(0.0)
    }

    @Test
    fun testMarketSummaries() {
        val expectedMarketName = "BTC-ETH"
        var result = ""
        publicBittrexService.getMarketSummaries()
                .filter { it.success }
                .map { it.result }
                .flatMap { Observable.fromIterable(it) }
                .filter { it.marketName == expectedMarketName }
                .subscribe {
                    result = it.marketName
                    println(it)
                }

        assertThat(result).isEqualTo(expectedMarketName)
    }
}