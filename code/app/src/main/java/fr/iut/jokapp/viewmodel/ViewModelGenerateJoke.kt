package fr.iut.jokapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.AvailableLanguages
import fr.iut.jokapp.local.modele.Flag
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.network.api.APIRequestParameter
import fr.iut.jokapp.network.api.Repository
import fr.iut.jokapp.network.api.RepositoryAPI
import fr.iut.jokapp.repository.RepositoryBD
import fr.iut.jokapp.repository.RepositoryPersistance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// View Model of the application
class ViewModelGenerateJoke : ViewModel() {

    // Repository to retrieve wanted jokes
    private var repository: Repository = RepositoryAPI()
    private var repositoryPersistance : RepositoryPersistance = RepositoryBD()

    // Retrieved joke
    private var _joke: MutableLiveData<Joke> = MutableLiveData<Joke>()
    val joke: LiveData<Joke>
        get() = _joke

    // Get any joke
    fun getJoke(
        categories: List<AvailableCategories>,
        choosenLanguage: AvailableLanguages,
        flags: Flag,
        types: APIRequestParameter
    ){
        viewModelScope.launch(Dispatchers.IO) {
            _joke.postValue(repository.getAnyJoke(categories, choosenLanguage, flags, types))
        }
    }


    fun addJoke() {
        viewModelScope.launch() {
            if (joke.value != null) {
                repositoryPersistance.addJoke(joke.value!!)
            }
        }
    }
}