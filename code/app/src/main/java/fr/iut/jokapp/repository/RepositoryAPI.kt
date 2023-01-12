package fr.iut.jokapp.repository

import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryAPI() {

    private var jokeApiService: JokeApiService

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://v2.jokeapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        jokeApiService = retrofit.create(JokeApiService::class.java)
    }

    public fun getAnyJoke(){
        var result = jokeApiService.getAnyJoke();
        // var result1 = result.await()
        if(true){
            var a = 1;
        }
    }
}