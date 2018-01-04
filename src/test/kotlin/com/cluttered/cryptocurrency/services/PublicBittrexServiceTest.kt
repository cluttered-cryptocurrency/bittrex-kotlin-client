package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.model.*
import io.reactivex.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.math.BigDecimal

class PublicBittrexServiceTest {

    private val publicBittrexService by lazy {
        PublicBittrexService.create()
    }

    @Test
    fun testBtcEthMarket() {
        val expectedMarketName = "BTC-ETH"
        var result: Market? = null
        publicBittrexService.getMarkets()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .filter { it.marketName == expectedMarketName }
                .firstElement()
                .subscribe {
                    result = it
                    println(it)
                }

        assertThat(result).isNotNull()
    }

    @Test
    fun testLtcCurrency() {
        val expectedCurrency = "LTC"
        var result: Currency? = null
        publicBittrexService.getCurrencies()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .filter { it.currency == expectedCurrency }
                .firstElement()
                .subscribe {
                    result = it
                    println(it)
                }

        assertThat(result).isNotNull()
    }

    @Test
    fun testTicker() {
        val market = "BTC-ETH"
        var result = Ticker(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO)
        publicBittrexService.getTicker(market)
                .filter { it.success }
                .map { it.result }
                .subscribe {
                    result = it
                    println("$market: $it")
                }

        assertThat(result.ask).isGreaterThan(BigDecimal.ZERO)
        assertThat(result.bid).isGreaterThan(BigDecimal.ZERO)
        assertThat(result.last).isGreaterThan(BigDecimal.ZERO)
    }

    @Test
    fun testMarketSummaries() {
        val expectedMarketName = "BTC-ETH"
        var result: MarketSummary? = null
        publicBittrexService.getMarketSummaries()
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .filter { it.marketName == expectedMarketName }
                .firstElement()
                .subscribe {
                    result = it
                    println(it)
                }

        assertThat(result).isNotNull()
    }

    @Test
    fun testMarketSummary() {
        val expectedMarketName = "BTC-WAVES"
        var result: MarketSummary? = null
        publicBittrexService.getMarketSummary(expectedMarketName)
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .firstElement()
                .subscribe {
                    result = it
                    println(it)
                }

        assertThat(result).isNotNull()
    }

    @Test
    fun testOrderLists() {
        val marketName = "BTC-ETH"
        var buyCount = -1
        var sellCount = -1
        val orderListsObservable = publicBittrexService
                .getOrderBook(marketName)
                .filter { it.success }
                .map { it.result }

        orderListsObservable.subscribe { buyCount = it.buy.size }
        orderListsObservable.subscribe { sellCount = it.sell.size }

        assertThat(buyCount).isGreaterThan(-1)
        assertThat(sellCount).isGreaterThan(-1)
    }

    @Test
    fun testBuyOrderList() {
        val marketName = "BTC-ETH"
        var count = -1
        publicBittrexService.getBuyOrderBook(marketName)
                .filter { it.success }
                .map { it.result }
                .subscribe { count = it.size }

        assertThat(count).isGreaterThan(-1)
    }

    @Test
    fun testSellOrderList() {
        val marketName = "BTC-ETH"
        var count = -1
        publicBittrexService.getSellOrderBook(marketName)
                .filter { it.success }
                .map { it.result }
                .subscribe { count = it.size }

        assertThat(count).isGreaterThan(-1)
    }

    @Test
    fun testMarketHistory() {
        val expectedMarketName = "BTC-WAVES"
        var result: MarketHistory? = null
        publicBittrexService.getMarketHistory(expectedMarketName)
                .filter { it.success }
                .flatMap { Observable.fromIterable(it.result) }
                .filter { it.orderType == MarketHistory.OrderType.BUY }
                .firstElement()
                .subscribe {
                    result = it
                    println(it)
                }

        assertThat(result).isNotNull()
    }
}