package fr.iut.jokapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iut.jokapp.local.model.Joke
import fr.iut.jokapp.repository.Repository
import fr.iut.jokapp.repository.RepositoryAPI
import kotlinx.coroutines.launch

// View Model of the application
class ApiViewModel : ViewModel() {

    // Repository to retrieve wanted jokes
    private var repository: Repository = RepositoryAPI()
    // Retrieved joke
    private var _joke: MutableLiveData<Joke> = MutableLiveData<Joke>()
    val joke: LiveData<Joke>
        get() = _joke

    // Get any joke
    fun getAnyJoke(){
        viewModelScope.launch {
            _joke.postValue(repository.getAnyJoke())
        }
    }
}