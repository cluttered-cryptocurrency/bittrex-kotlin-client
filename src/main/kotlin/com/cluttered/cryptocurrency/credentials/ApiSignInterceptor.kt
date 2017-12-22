package com.cluttered.cryptocurrency.credentials

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class ApiSignInterceptor(private val key: String, secret: String) : Interceptor {

    private val hmacSha512 = HmacSha512(secret)

    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url()

        // Ignore if using public api
        if (url.encodedPath().contains("public"))
            return chain.proceed(chain.request())

        val currentMillis = System.currentTimeMillis()
        var modifiedUrl = url.toString()
        modifiedUrl += (if (modifiedUrl.contains('?')) '&' else '?') +
                "apikey=$key&nonce=$currentMillis"
        val signedUrl = hmacSha512.encode(modifiedUrl)
        val request = chain.request().newBuilder()
                .url(modifiedUrl)
                .addHeader("apisign", signedUrl)
                .build()
        return chain.proceed(request)
    }
}