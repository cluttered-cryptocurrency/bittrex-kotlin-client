package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.services.PublicBittrexService
import io.reactivex.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class BittrexClientTest {

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

}