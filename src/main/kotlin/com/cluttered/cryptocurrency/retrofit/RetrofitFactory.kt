package com.cluttered.cryptocurrency.retrofit

import com.cluttered.cryptocurrency.credentials.ApiSignInterceptor
import com.cluttered.cryptocurrency.marshallers.ZonedDateTimeDeserializer
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.time.ZonedDateTime
import okhttp3.logging.HttpLoggingInterceptor.Level
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY


object RetrofitFactory {

    @JvmStatic
    fun create(key: String = "", secret: String = "", level: Level = BODY): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(createGsonConverterFactory())
                .client(createOkHttpClient(key, secret, level))
                .baseUrl("https://bittrex.com/api/")
                .build()
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
    private fun createOkHttpClient(key: String, secret: String, level: Level): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(level))

        if (key.isNotBlank() && secret.isNotBlank()) {
            builder.addNetworkInterceptor(ApiSignInterceptor(key, secret))
        }

        return builder.build()
    }
}