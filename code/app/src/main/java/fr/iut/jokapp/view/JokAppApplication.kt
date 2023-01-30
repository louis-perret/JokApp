package fr.iut.jokapp.view

import android.app.Application
import fr.iut.jokapp.repository.room.JokeDatabase

class JokAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        JokeDatabase.initialize(this)
    }
}