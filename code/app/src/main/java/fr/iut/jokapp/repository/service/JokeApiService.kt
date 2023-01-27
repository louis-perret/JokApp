package fr.iut.jokapp.repository.service

import fr.iut.jokapp.local.model.Joke
import fr.iut.jokapp.repository.APIRequestParameter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// Service which execute web requests to the API JokeAPI
interface JokeApiService {

    // Simple Get method to get any joke
    @GET("joke/{categ}")
    fun getAnyJoke(@Path("categ") categ: APIRequestParameter): Call<Joke>
}