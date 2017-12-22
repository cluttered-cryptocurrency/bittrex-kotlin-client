package com.cluttered.cryptocurrency.retrofit

import com.cluttered.cryptocurrency.credentials.ApiSignInterceptor
import com.cluttered.cryptocurrency.marshallers.ZonedDateTimeDeserializer
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.time.ZonedDateTime

object RetrofitFactory {

    @JvmStatic
    fun create(secret: String = ""): Retrofit {
        val builder = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(createGsonConverterFactory())
                .baseUrl("https://bittrex.com/api/")

        if (secret.isNotBlank())
            builder.client(createApiSignInterceptor(secret))

        return builder.build()
    }

    @JvmStatic
    private fun createGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
                GsonBuilder()
                        .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeDeserializer())
                        .serializeNulls()
                        .create())
    }

    @JvmStatic
    private fun createApiSignInterceptor(secret: String): OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(ApiSignInterceptor(secret))
                .build()
    }
}