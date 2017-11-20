package com.cluttered.cryptocurrency.credentials

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiSignInterceptor : Interceptor {

    companion object {
        private const val API_SIGN: String = "apisign"

        const val API_KEY: String = "apikey"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url()

        // Ignore if API_KEY is absent
        url.queryParameter(API_KEY) ?:
                return chain.proceed(chain.request())

        val currentMillis = System.currentTimeMillis()
        val modifiedUrl = url.toString() + "&nonce=" + currentMillis
        val signedUrl = Cryptography.hmacSHA512(modifiedUrl, Credentials.secret!!)
        val request = chain.request().newBuilder()
                .url(modifiedUrl)
                .addHeader(API_SIGN, signedUrl)
                .build()
        return chain.proceed(request)
    }
}