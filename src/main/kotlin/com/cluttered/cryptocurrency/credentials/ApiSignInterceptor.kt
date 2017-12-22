package com.cluttered.cryptocurrency.credentials

import okhttp3.Interceptor
import okhttp3.Response

class ApiSignInterceptor(private val key: String, secret: String) : Interceptor {

    private val hmacSHA512 = HmacSHA512(secret)

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url()

        // Ignore if using public api
        if (url.encodedPath().contains("public"))
            return chain.proceed(chain.request())

        val currentMillis = System.currentTimeMillis()
        var modifiedUrl = url.toString()
        modifiedUrl += (if (modifiedUrl.contains('?')) '&' else '?')
        modifiedUrl += "apikey=$key&nonce=$currentMillis"

        val signedUrl = hmacSHA512.encode(modifiedUrl)
        val request = chain.request().newBuilder()
                .url(modifiedUrl)
                .addHeader("apisign", signedUrl)
                .build()
        return chain.proceed(request)
    }
}