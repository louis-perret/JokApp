package fr.iut.jokapp.repository

import retrofit2.Retrofit

class RepositoryAPI {

    private lateinit var jokeApiService: JokeApiService

    constructor(){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://v2.jokeapi.dev/")
            .build()

        jokeApiService = retrofit.create(JokeApiService::class.java)
    }

    public fun getAnyJoke(){
        var result = jokeApiService.getAnyJoke();
        if(true){
            var a = 1;
        }

        Json
    }
}