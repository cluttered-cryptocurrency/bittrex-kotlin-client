package com.cluttered.cryptocurrency.marshallers

import com.google.gson.*
import java.lang.reflect.Type
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ZonedDateTimeMarshaller : JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {

    companion object {
        val FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]['Z']")
                .withZone(ZoneId.of("UTC"))
    }

    override fun serialize(src: ZonedDateTime, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(FORMATTER.format(src))
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ZonedDateTime {
        var dateString = json.asJsonPrimitive.asString
        val index = dateString.indexOf('.')
        if (index > -1) {
            val chars = CharArray(4 - (dateString.length - index))
            Arrays.fill(chars, '0')
            dateString += String(chars)
        }
        return ZonedDateTime.from(FORMATTER.parse(dateString))
    }
}