package fr.iut.jokapp.local.modele

import com.google.gson.annotations.SerializedName

// Represents retrieved joke from the API
data class Joke(
    @SerializedName("id")
    var id: Int,
    @SerializedName("formatVersion")
    var formatVersion: String?,
    @SerializedName("category")
    var category: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("joke")
    var joke: String?,
    @SerializedName("setup")
    var setup: String?,
    @SerializedName("delivery")
    var delivery: String?,
    @SerializedName("flags")
    var flags: Flag,
    @SerializedName("lang")
    var lang: String
) {
}