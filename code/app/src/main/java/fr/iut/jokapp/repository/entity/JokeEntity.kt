package fr.iut.jokapp.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.AvailableLanguages
import fr.iut.jokapp.local.modele.Flag

const val NEW_JOKE_ID = 0L

@Entity
class JokeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = NEW_JOKE_ID,
    var formatVersion: String = "",
    var category: List<AvailableCategories>? = null,
    var type: String = "",
    var joke: String? = null,
    var setup: String? = null,
    var delivery: String? = null,
    // private var flags: Flag = "",
    var lang: AvailableLanguages = AvailableLanguages.En
) {
}