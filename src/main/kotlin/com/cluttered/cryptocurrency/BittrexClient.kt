package com.cluttered.cryptocurrency

import com.cluttered.cryptocurrency.services.PublicBittrexService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BittrexClient {

    companion object {
        const val BITTREX_API_URL: String = "https://bittrex.com/api/"
    }

    private val retrofit: Retrofit
    private val public: PublicBittrexService

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BITTREX_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        public = retrofit.create(PublicBittrexService::class.java)
    }
}