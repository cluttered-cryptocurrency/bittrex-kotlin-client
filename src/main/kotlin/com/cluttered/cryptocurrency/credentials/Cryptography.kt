package com.cluttered.cryptocurrency.credentials

import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SignatureException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object Cryptography {

    private val HMAC_SHA512 = "HmacSHA512"

    @Throws(SignatureException::class, NoSuchAlgorithmException::class, InvalidKeyException::class)
    fun hmacSHA512(uri: String, secret: String): String {
        val secretKeySpec = SecretKeySpec(secret.toByteArray(), HMAC_SHA512)
        val mac = Mac.getInstance(HMAC_SHA512)
        mac.init(secretKeySpec)
        val bytes: ByteArray = mac.doFinal(uri.toByteArray())
        var hexString = ""
        for (byte in bytes) {
            hexString += String.format("%02X", byte)
        }
        return hexString
    }
}