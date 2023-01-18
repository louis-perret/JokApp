package fr.iut.jokapp.viewmodel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.iut.jokapp.repository.Repository
import fr.iut.jokapp.repository.RepositoryAPI
import fr.iut.jokapp.viewmodel.ApiViewModel

class ApiViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ApiViewModel(repository) as T
    }

}