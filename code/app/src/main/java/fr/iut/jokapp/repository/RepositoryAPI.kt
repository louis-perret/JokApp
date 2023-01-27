package fr.iut.jokapp.repository

import fr.iut.jokapp.local.model.Joke
import fr.iut.jokapp.repository.service.JokeApiService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

// The repository which do request and treat answers from the API JokeAPI
class RepositoryAPI() : Repository{

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
    override suspend fun getAnyJoke() : Joke?{
        val test = APIRequestParameter()
        test.addValue("Programming")
        test.addValue("Miscellaneous")
        var testString = test.toString()
        return jokeApiService.getAnyJoke(test).await()
    }
}