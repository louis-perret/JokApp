package fr.iut.jokapp.local.modele

import com.google.gson.annotations.SerializedName

// Represents retrieved joke from the API
data class Joke(
    @SerializedName("formatVersion")
    private var formatVersion: String,
    @SerializedName("category")
    private var category: String,
    @SerializedName("type")
    private var type: String,
    @SerializedName("joke")
    var joke: String?,
    @SerializedName("setup")
    var setup: String?,
    @SerializedName("delivery")
    var delivery: String?,
    @SerializedName("flags")
    private var flags: Flag,
    @SerializedName("lang")
    private var lang: String
) {
}