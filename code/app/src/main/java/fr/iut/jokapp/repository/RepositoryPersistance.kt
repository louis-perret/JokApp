package fr.iut.jokapp.repository

import androidx.lifecycle.LiveData
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.entity.JokeEntity

interface RepositoryPersistance {

    fun getAllJoke() : LiveData<List<JokeEntity>>

    suspend fun addJoke(joke: Joke)

    suspend fun deleteJoke(joke: JokeEntity)
}