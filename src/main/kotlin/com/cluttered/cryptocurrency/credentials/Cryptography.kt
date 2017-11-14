package com.cluttered.cryptocurrency.credentials

import java.nio.charset.Charset
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SignatureException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object Cryptography {

    private val HMAC_SHA512 = "HmacSHA512"
    private val UTF_8 = "UTF-8"

    @Throws(SignatureException::class, NoSuchAlgorithmException::class, InvalidKeyException::class)
    fun hmacSHA512(uri: String, secret: String): String {
        val secretKeySpec = SecretKeySpec(secret.toByteArray(), HMAC_SHA512)
        val mac = Mac.getInstance(HMAC_SHA512)
        mac.init(secretKeySpec)
        val bytes: ByteArray = mac.doFinal(uri.toByteArray())
        return String(bytes, Charset.forName(UTF_8))
    }
}