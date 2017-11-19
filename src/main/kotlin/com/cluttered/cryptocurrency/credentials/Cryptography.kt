package com.cluttered.cryptocurrency.credentials

import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SignatureException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object Cryptography {

    private const val HMAC_SHA512 = "HmacSHA512"

    @Throws(SignatureException::class, NoSuchAlgorithmException::class, InvalidKeyException::class)
    fun hmacSHA512(uri: String, secret: String): String {
        val secretKeySpec = SecretKeySpec(secret.toByteArray(), HMAC_SHA512)
        val mac = Mac.getInstance(HMAC_SHA512)
        mac.init(secretKeySpec)
        return mac.doFinal(uri.toByteArray())
                .map { String.format("%02X", it) }
                .reduce { acc, str -> acc + str }
    }
}