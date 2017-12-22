package com.cluttered.cryptocurrency.credentials

import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SignatureException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class HmacSHA512(secret: String) {

    companion object {
        private const val HEX_FORMAT = "%02X"
    }

    private val mac: Mac

    init {
        val hmacSHA512 = "HmacSHA512"
        val secretBytes = secret.toByteArray()
        val secretKeySpec = SecretKeySpec(secretBytes, hmacSHA512)
        mac = Mac.getInstance(hmacSHA512)
        mac.init(secretKeySpec)
    }

    @Throws(SignatureException::class, NoSuchAlgorithmException::class, InvalidKeyException::class)
    fun encode(uri: String): String {
        return mac.doFinal(uri.toByteArray())
                .map { String.format(HEX_FORMAT, it) }
                .reduce { acc, str -> acc + str }
    }
}