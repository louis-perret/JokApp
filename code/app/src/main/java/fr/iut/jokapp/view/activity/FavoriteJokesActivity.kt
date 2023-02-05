package fr.iut.jokapp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import fr.iut.jokapp.R
import fr.iut.jokapp.repository.room.JokeDatabase
import fr.iut.jokapp.view.adapter.RecyclerViewAdapterJoke
import fr.iut.jokapp.repository.converter.toModel
import fr.iut.jokapp.repository.converter.toModels

class FavoriteJokesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_favorite_jokes)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJoke)
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        recyclerView.adapter = RecyclerViewAdapterJoke(JokeDatabase.getInstance().jokeDAO().getAll().toModels())
    }


    companion object {
        fun getIntent(context: Context) = Intent(context, FavoriteJokesActivity::class.java)
    }
}