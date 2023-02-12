package fr.iut.jokapp.view

import android.app.Application
import fr.iut.jokapp.repository.room.JokeDatabase

class JokAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        JokeDatabase.initialize(this)
    }

    companion object {
        val NAMESHAREDPREFERENCES = "JokAppSharedPreferences"
        val FIRSTRENDER = "firstRender"

        val ISCHECKEDPROGRAMMING = "isCheckedProgramming"
        val ISCHECKEDMISC = "isCheckedMisc"
        val ISCHECKEDDARK = "isCheckedDark"
        val ISCHECKEDPUN = "isCheckedPun"
        val ISCHECKEDSPOOKY = "isCheckedSpooky"
        val ISCHECKEDCHRISTMAS = "isCheckedChristmas"

        val ISCHECKEDNSFW = "isCheckedNsfw"
        val ISCHECKEDRELIGIOUS = "isCheckedReligious"
        val ISCHECKEDPOLITICAL = "isCheckedPolitical"
        val ISCHECKEDRACIST = "isCheckedRacist"
        val ISCHECKEDSEXIST = "isCheckedSexist"
        val ISCHECKEDEXPLICIT = "isCheckedExplicit"

        val CHOOSENLANGUAGE = "choosenLanguage"

        val ISSINGLEJOKE = "isSingleJoke"
        val ISTWOPARTJOKE = "isTwoPartJoke"
    }
}