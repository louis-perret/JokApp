package fr.iut.jokapp.local.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("formatVersion")
    private var formatVersion: String,
    @SerializedName("category")
    private var category: String,
    @SerializedName("type")
    private var type: String,
    @SerializedName("joke")
    private var joke: String,
    @SerializedName("setup")
    private var setup: String,
    @SerializedName("delivery")
    private var delivery: String,
    @SerializedName("flags")
    private var flags: Flag,
    @SerializedName("lang")
    private var lang: String
) {
}