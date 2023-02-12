package fr.iut.jokapp.repository.converter

import androidx.room.TypeConverter
import fr.iut.jokapp.local.modele.AvailableLanguages

// Get an enum according to a number
fun Int.toAvailableLanguages() = enumValues<AvailableLanguages>()[this]

// Allows the conversion between AvailableLanguage and Int
class AvailableLanguagesToInt {

    // Convert an Int into an AvailableLanguage
    @TypeConverter
    fun fromInt(ordinal: Int) = ordinal.toAvailableLanguages()

    // Convert a language into an int
    @TypeConverter
    fun toOrdinal(language: AvailableLanguages) = language.ordinal
}
