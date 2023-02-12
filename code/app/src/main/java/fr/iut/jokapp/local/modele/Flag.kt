package fr.iut.jokapp.local.modele

import com.google.gson.annotations.SerializedName
import kotlin.math.exp

// Represent retrieved flags from the API
data class Flag(
    @SerializedName("nsfw")
    var nsfw: Boolean,
    @SerializedName("religious")
    var religious: Boolean,
    @SerializedName("political")
    var political: Boolean,
    @SerializedName("racist")
    var racist: Boolean,
    @SerializedName("sexist")
    var sexist: Boolean,
    @SerializedName("explicit")
    var explicit: Boolean
){
    // Turn the values into an acceptable string for the web request
    override fun toString(): String {
        val res = StringBuilder()
        if(nsfw) res.append("nsfw,")
        if(religious) res.append("religious,")
        if(political) res.append("political,")
        if(racist) res.append("racist,")
        if(sexist) res.append("sexist,")
        if(explicit) res.append("explicit,")
        return res.dropLast(1).toString()
    }
}