package fr.iut.jokapp.repository.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.AvailableLanguages
import fr.iut.jokapp.local.modele.Flag

const val NEW_JOKE_ID = 0

@Entity(tableName = "jokes")
class JokeEntity(
    @PrimaryKey val id: Int = NEW_JOKE_ID,
    var formatVersion: String? = null,
    var category: String = "",
    var type: String = "",
    var joke: String? = null,
    var setup: String? = null,
    var delivery: String? = null,
    @Embedded var flags : Flag? = null,
    var lang: AvailableLanguages = AvailableLanguages.En
) {
}