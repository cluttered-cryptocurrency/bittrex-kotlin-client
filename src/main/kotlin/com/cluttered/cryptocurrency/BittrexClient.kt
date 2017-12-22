package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.retrofit.RetrofitFactory
import com.cluttered.cryptocurrency.services.AccountBittrexService
import com.cluttered.cryptocurrency.services.MarketBittrexService
import com.cluttered.cryptocurrency.services.PublicBittrexService

class BittrexClient(key: String, secret: String) {

    private val retrofit = RetrofitFactory.create(key, secret)

    val public by lazy {
        PublicBittrexService.create(retrofit)
    }

    val market by lazy {
        MarketBittrexService.create(retrofit)
    }

    val account by lazy {
        AccountBittrexService.create(retrofit)
    }
}