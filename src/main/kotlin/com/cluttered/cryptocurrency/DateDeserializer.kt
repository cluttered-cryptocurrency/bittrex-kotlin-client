package com.cluttered.cryptocurrency

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer : JsonDeserializer<Date> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Date {
        val dateString = json.asJsonPrimitive.asString
        return try {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(dateString)
        } catch (ex: ParseException) {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateString)
        }
    }
}