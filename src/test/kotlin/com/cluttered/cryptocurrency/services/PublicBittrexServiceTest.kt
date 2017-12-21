package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.model.OrderLists
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
                .flatMap { Observable.fromIterable(it.result) }
                .filter { it.marketName == expectedMarketName }
                .firstElement()
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
                .flatMap { Observable.fromIterable(it.result) }
                .filter { it.currency == expectedCurrency }
                .firstElement()
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
                .flatMap { Observable.fromIterable(it.result) }
                .filter { it.marketName == expectedMarketName }
                .firstElement()
                .subscribe {
                    result = it.marketName
                    println(it)
                }

        assertThat(result).isEqualTo(expectedMarketName)
    }

    @Test
    fun testMarketSummary() {
        val expectedMarketName = "BTC-WAVES"
        var result = ""
        publicBittrexService.getMarketSummary(expectedMarketName)
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .firstElement()
                .subscribe {
                    result = it.marketName
                    println(it)
                }

        assertThat(result).isEqualTo(expectedMarketName)
    }

    @Test
    fun testBothOrderLists() {
        val marketName = "BTC-ARDR"
        var buyCount = -1
        var sellCount = -1
        val orderListsObservable = publicBittrexService
                .getBothOrderBook(marketName)
                .filter { it.success }
                .map { it.result }

        orderListsObservable.subscribe { buyCount = it.buy.size }
        orderListsObservable.subscribe { sellCount = it.sell.size }

        assertThat(buyCount).isGreaterThan(-1)
        assertThat(sellCount).isGreaterThan(-1)
    }

    @Test
    fun testBuyOrderList() {
        val marketName = "BTC-ARDR"
        var count = -1
        publicBittrexService.getBuyOrderBook(marketName)
                .filter { it.success }
                .map { it.result }
                .subscribe { count = it.size }

        assertThat(count).isGreaterThan(-1)
    }

    @Test
    fun testSellOrderList() {
        val marketName = "BTC-ARDR"
        var count = -1
        publicBittrexService.getSellOrderBook(marketName)
                .filter { it.success }
                .map { it.result }
                .subscribe { count = it.size }

        assertThat(count).isGreaterThan(-1)
    }
}