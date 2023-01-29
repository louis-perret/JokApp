package fr.iut.jokapp.repository.service

import fr.iut.jokapp.local.modele.Flag
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.APIRequestParameter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Service which execute web requests to the API JokeAPI
interface JokeApiService {

    /* Simple Get method to get any joke
        Parameters :
            - categs : Representing choosen categories (programming, dark, pun...)
    */
    @GET("joke/{categs}")
    fun getAnyJoke(
        @Path("categs") categs: APIRequestParameter,
        @Query("lang") lang: String,
        @Query("blacklistFlags") flags: Flag
    ): Call<Joke>
}