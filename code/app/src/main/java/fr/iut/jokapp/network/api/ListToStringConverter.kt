package fr.iut.jokapp.network.api

import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class ListToStringConverter : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {
        if(type == List::class.java) {
            val values = type as List<String>
            if (values == null) {
                return super.stringConverter(type, annotations, retrofit)
            }
            else {
                var result = StringBuilder()
                for (value in type) {
                    result.append(value)
                    result.append(",")
                }
                return Converter<Any, String> { result.dropLast(1).toString() }
            }
        }
        else {
            return super.stringConverter(type, annotations, retrofit)
        }
    }
}