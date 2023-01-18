package fr.iut.jokapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iut.jokapp.local.model.Joke
import fr.iut.jokapp.repository.Repository
import fr.iut.jokapp.repository.RepositoryAPI
import kotlinx.coroutines.launch

class ApiViewModel(private var repository: Repository) : ViewModel() {

    private lateinit var _joke: MutableLiveData<Joke>
    val joke: LiveData<Joke>
        get() = _joke

    fun getAnyJoke(){
        viewModelScope.launch {
            _joke.postValue(repository.getAnyJoke())
        }
    }
}