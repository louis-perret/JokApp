package fr.iut.jokapp.repository.converter

import androidx.room.TypeConverter
import fr.iut.jokapp.local.modele.AvailableCategories

// Allows the conversion between AvailableCategories and String
class ListAvailableCategoriesToString {

    // Convert a String into a list of AvailableCategories
    @TypeConverter
    fun fromString(input: String) : List<AvailableCategories> {
        val res = ArrayList<AvailableCategories>()
        val inputAfterSplit = input.split(",")
        val arrayAvailableCategories = enumValues<AvailableCategories>()
        for(str in inputAfterSplit) {
            res.add(arrayAvailableCategories[str.toInt()])
        }
        return res
    }

    // Convert a list of AvailableCategories into a String
    @TypeConverter
    fun toString(input: List<AvailableCategories>) : String {
        val res = StringBuilder()
        for(categ in input) {
            res.append("${categ.ordinal},")
        }
        return res.dropLast(1).toString()
    }
}