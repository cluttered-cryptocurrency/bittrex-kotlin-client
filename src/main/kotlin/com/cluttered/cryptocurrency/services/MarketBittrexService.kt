package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.marshallers.ZonedDateTimeDeserializer
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.time.ZonedDateTime

interface MarketBittrexService {

    companion object {
        const val V1_PUBLIC: String = "v1.1/public"
        const val MARKET: String = "market"

        fun create(): PublicBittrexService {
            val gson = GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeDeserializer())
                    .serializeNulls()
                    .create()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl("https://bittrex.com/api/")
                    .build()

            return create(retrofit)
        }

        fun create(retrofit: Retrofit): PublicBittrexService {
            return retrofit.create(PublicBittrexService::class.java)
        }
    }
}