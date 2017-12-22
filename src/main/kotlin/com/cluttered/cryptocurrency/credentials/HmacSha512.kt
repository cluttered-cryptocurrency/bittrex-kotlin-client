package com.cluttered.cryptocurrency.credentials

import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SignatureException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class HmacSha512(secret: String) {

    companion object {
        private const val HMAC_SHA512 = "HmacSHA512"
    }

    private val mac: Mac

    init {
        val secretBytes = secret.toByteArray()
        val secretKeySpec = SecretKeySpec(secretBytes, HMAC_SHA512)
        mac = Mac.getInstance(HMAC_SHA512)
        mac.init(secretKeySpec)
    }

    @Throws(SignatureException::class, NoSuchAlgorithmException::class, InvalidKeyException::class)
    fun encode(uri: String): String {
        return mac.doFinal(uri.toByteArray())
                .map { String.format("%02X", it) }
                .reduce { acc, str -> acc + str }
    }
}