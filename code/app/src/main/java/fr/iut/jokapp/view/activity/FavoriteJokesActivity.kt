package fr.iut.jokapp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import fr.iut.jokapp.R
import fr.iut.jokapp.repository.entity.JokeEntity
import fr.iut.jokapp.view.adapter.RecyclerViewAdapterJoke
import fr.iut.jokapp.view.callbacks.OnDeleteJokeListener
import fr.iut.jokapp.viewmodel.ViewModelFavoriteJoke

class FavoriteJokesActivity : AppCompatActivity(), OnDeleteJokeListener {

    private lateinit var viewModelJokeApp: ViewModelFavoriteJoke

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_favorite_jokes)

        viewModelJokeApp = ViewModelProvider(this).get(fr.iut.jokapp.viewmodel.ViewModelFavoriteJoke::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJoke)
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        var adapter = RecyclerViewAdapterJoke(this)
        recyclerView.adapter = adapter

        viewModelJokeApp.jokes.observe(this) {
            adapter.submitList(it)
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, FavoriteJokesActivity::class.java)
    }

    override fun deleteJoke(joke: JokeEntity?, position: Int) {
        viewModelJokeApp.deleteJoke(joke)
    }


}