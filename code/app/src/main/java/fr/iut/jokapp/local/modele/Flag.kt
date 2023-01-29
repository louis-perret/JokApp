package fr.iut.jokapp.local.modele

import com.google.gson.annotations.SerializedName
import kotlin.math.exp

// Represent retrieved flags from the API
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