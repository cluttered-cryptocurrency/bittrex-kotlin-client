package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.services.PublicBittrexService

class PublicBittrexClient {

    val public by lazy {
        PublicBittrexService.create()
    }
}