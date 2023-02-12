package fr.iut.jokapp.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.RepositoryBD
import fr.iut.jokapp.repository.RepositoryPersistance
import fr.iut.jokapp.repository.entity.JokeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// View-Model for the FavoriteJokesActivity
class ViewModelFavoriteJoke : ViewModel() {

    // Repository to do request to the database
    private var repositoryPersistance : RepositoryPersistance = RepositoryBD()

    // Favorite joke
    val jokes = repositoryPersistance.getAllJoke()

    fun deleteJoke(joke: JokeEntity?) {
        viewModelScope.launch(Dispatchers.IO) {
            if(joke != null) {
                repositoryPersistance.deleteJoke(joke)
            }
        }
    }
}