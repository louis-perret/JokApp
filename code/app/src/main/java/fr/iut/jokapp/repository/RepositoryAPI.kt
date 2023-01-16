package fr.iut.jokapp.repository

import android.util.Log
import fr.iut.jokapp.local.model.Joke
import retrofit2.*
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

    fun getAnyJoke(){
        var joke: Joke? = null
        var request = jokeApiService.getAnyJoke();
        //var response = request.execute()
        request.enqueue(object: Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if(response.isSuccessful){
                    var joke1 = response.body()
                    var i = 1
                    i = 1 + 6
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.i("OnFailure", t.message!!)
            }

        })
    }
}