package fr.iut.jokapp.repository.converter

import androidx.room.TypeConverter
import fr.iut.jokapp.local.modele.AvailableLanguages

fun Int.toAvailableLanguages() = enumValues<AvailableLanguages>()[this]

class AvailableLanguagesToInt {

    @TypeConverter
    fun fromInt(ordinal: Int) = ordinal.toAvailableLanguages()

    @TypeConverter
    fun toOrdinal(language: AvailableLanguages) = language.ordinal
}
