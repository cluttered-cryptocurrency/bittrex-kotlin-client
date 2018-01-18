package com.cluttered.cryptocurrency.retrofit

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

object HostCookieJar : CookieJar {

    private var cookies = mutableListOf<Cookie>()

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        HostCookieJar.cookies = cookies
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        return cookies
    }
}