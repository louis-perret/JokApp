package fr.iut.jokapp.repository

import androidx.lifecycle.LiveData
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.entity.JokeEntity

// Execute request to the database
interface RepositoryPersistance {

    // Get all jokes
    fun getAllJoke() : LiveData<List<JokeEntity>>

    // Insert a joke
    suspend fun addJoke(joke: Joke)

    // Delete a joke
    suspend fun deleteJoke(joke: JokeEntity)
}