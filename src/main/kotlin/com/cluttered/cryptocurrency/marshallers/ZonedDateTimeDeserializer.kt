package com.cluttered.cryptocurrency.marshallers

import com.google.gson.*
import java.lang.reflect.Type
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ZonedDateTimeDeserializer : JsonDeserializer<ZonedDateTime> {

    companion object {
        val FORMATTER: DateTimeFormatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]")
                .withZone(ZoneId.of("UTC"))
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ZonedDateTime {
        var dateString = json.asJsonPrimitive.asString
        val missingMillis = 3 - (dateString.length - dateString.indexOf('.'))
        for (i in 0..missingMillis) {
            dateString += '0'
        }
        return ZonedDateTime.from(FORMATTER.parse(dateString))
    }
}