package com.cluttered.cryptocurrency.credentials

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiSignInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url()
        val key: String? = url.queryParameter("apikey")
        if (key != null) {
            val currentMillis = System.currentTimeMillis()
            val modifiedUrl = url.toString() + "&nonce=" + currentMillis
            val signedUrl = Cryptography.hmacSHA512(modifiedUrl, Credentials.secret!!)
            val request: Request = chain.request().newBuilder()
                    .url(modifiedUrl)
                    .addHeader("apisign", signedUrl)
                    .build()
            return chain.proceed(request)
        }
        return chain.proceed(chain.request())
    }
}