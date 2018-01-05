package com.cluttered.cryptocurrency.retrofit

import com.cluttered.cryptocurrency.credentials.ApiSignInterceptor
import com.cluttered.cryptocurrency.marshallers.InstantDeserializer
import com.google.gson.GsonBuilder
import devcsrj.okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Instant
import org.slf4j.LoggerFactory


object RetrofitFactory {

    private val LOG = LoggerFactory.getLogger("Retrofit")

    @JvmStatic
    fun create(key: String = "", secret: String = ""): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(createGsonConverterFactory())
                .client(createOkHttpClient(key, secret))
                .baseUrl("https://bittrex.com/api/")
                .build()
    }

    @JvmStatic
    private fun createGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
                GsonBuilder()
                        .registerTypeAdapter(Instant::class.java, InstantDeserializer())
                        .serializeNulls()
                        .create())
    }

    @JvmStatic
    private fun createOkHttpClient(key: String, secret: String): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor(LOG))

        if (key.isNotBlank() && secret.isNotBlank()) {
            builder.addNetworkInterceptor(ApiSignInterceptor(key, secret))
        }

        return builder.build()
    }
}