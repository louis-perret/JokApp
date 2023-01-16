package fr.iut.jokapp.local.model

import com.google.gson.annotations.SerializedName

data class Flag(
    @SerializedName("nsfw")
    private var nsfw: Boolean,
    @SerializedName("religious")
    private var religious: Boolean,
    @SerializedName("political")
    private var political: Boolean,
    @SerializedName("racist")
    private var racist: Boolean,
    @SerializedName("sexist")
    private var sexist: Boolean,
    @SerializedName("explicit")
    private var explicit: Boolean
){

}