package com.cluttered.cryptocurrency.services

import com.cluttered.cryptocurrency.marshallers.ZonedDateTimeMarshaller
import com.cluttered.cryptocurrency.model.ApiResponse
import com.cluttered.cryptocurrency.model.Market
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.time.ZonedDateTime

interface PublicBittrexService {

    companion object {
        const val V1_PUBLIC: String = "v1.1/public"

        fun create(): PublicBittrexService {
            val gson = GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeMarshaller())
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

    @GET("$V1_PUBLIC/getmarkets")
    fun getMarkets(): Observable<ApiResponse<List<Market>>>
}