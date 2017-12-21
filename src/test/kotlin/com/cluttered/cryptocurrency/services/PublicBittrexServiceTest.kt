package com.cluttered.cryptocurrency.services

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
    fun test() {
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

}