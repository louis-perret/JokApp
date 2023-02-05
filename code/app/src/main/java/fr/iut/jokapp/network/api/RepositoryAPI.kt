package fr.iut.jokapp.network.api

import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.AvailableLanguages
import fr.iut.jokapp.local.modele.Flag
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.network.service.JokeApiService
import fr.iut.jokapp.repository.room.JokeDatabase
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

// The repository which do request and treat answers from the API JokeAPI
class RepositoryAPI() : Repository {

    // Service which execute web requests
    private var jokeApiService: JokeApiService

    // Initializer
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://v2.jokeapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        jokeApiService = retrofit.create(JokeApiService::class.java)
    }

    // Get any joke independant of choosen parameters
    override suspend fun getAnyJoke(
        categories: List<AvailableCategories>,
        language: AvailableLanguages,
        flags: Flag,
        types: APIRequestParameter
    ): Joke? {
        var parameterCategories = APIRequestParameter()
        for(categ in categories) {
            parameterCategories.addValue(categ.toString())
        }

        val joke = jokeApiService.getAnyJoke(parameterCategories, language.toString().lowercase(), flags, types).await()
        return joke
    }
}