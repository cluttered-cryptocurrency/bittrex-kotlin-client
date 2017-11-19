package com.cluttered.cryptocurrency.credentials

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiSignInterceptor : Interceptor {

    companion object {
        const val API_KEY = "apikey"
    }

    private val API_SIGN: String = "apisign"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url()
        // Only sign if API_KEY is present
        url.queryParameter(API_KEY) ?: return chain.proceed(chain.request())
        val currentMillis = System.currentTimeMillis()
        val modifiedUrl = url.toString() + "&nonce=" + currentMillis
        val signedUrl = Cryptography.hmacSHA512(modifiedUrl, Credentials.secret!!)
        val request: Request = chain.request().newBuilder()
                .url(modifiedUrl)
                .addHeader(API_SIGN, signedUrl)
                .build()
        return chain.proceed(request)
    }
}