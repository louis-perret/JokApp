package fr.iut.jokapp.repository

import androidx.appcompat.app.ActionBar.DisplayOptions
import androidx.coordinatorlayout.widget.CoordinatorLayout.DispatchChangeEvent
import androidx.lifecycle.LiveData
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.converter.toEntity
import fr.iut.jokapp.repository.entity.JokeEntity
import fr.iut.jokapp.repository.room.JokeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryBD : RepositoryPersistance {
    override fun getAllJoke() = JokeDatabase.getInstance().jokeDAO().getAll()

    override suspend fun addJoke(joke: Joke) = withContext(Dispatchers.IO) { JokeDatabase.getInstance().jokeDAO().insertJoke(joke.toEntity()) }

    override suspend fun deleteJoke(joke: JokeEntity) = withContext(Dispatchers.IO) { JokeDatabase.getInstance().jokeDAO().delete(joke) }
}