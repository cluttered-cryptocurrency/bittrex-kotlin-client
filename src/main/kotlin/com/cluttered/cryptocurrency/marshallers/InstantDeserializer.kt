package com.cluttered.cryptocurrency.marshallers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class InstantDeserializer : JsonDeserializer<Instant> {

    companion object {
        val FORMATTER: DateTimeFormatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]")
                .withZone(ZoneId.of("UTC"))
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Instant {
        var dateString = json.asJsonPrimitive.asString
        val missingMillis = 4 - (dateString.length - dateString.indexOf('.'))
        when (missingMillis) {
            2 -> dateString += "00"
            1 -> dateString += "0"
        }
        return FORMATTER.parse(dateString, Instant::from)
    }
}