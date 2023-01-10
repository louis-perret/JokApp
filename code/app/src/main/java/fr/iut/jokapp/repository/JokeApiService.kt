package fr.iut.jokapp.repository

import fr.iut.jokapp.local.model.Joke
import retrofit2.http.GET

interface JokeApiService {

    @GET("joke/Any")
    fun getAnyJoke(): Joke
}