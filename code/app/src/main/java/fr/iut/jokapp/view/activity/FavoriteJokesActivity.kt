package fr.iut.jokapp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.room.JokeDatabase
import fr.iut.jokapp.view.adapter.RecyclerViewAdapterJoke
import fr.iut.jokapp.repository.converter.toModel
import fr.iut.jokapp.repository.converter.toModels
import fr.iut.jokapp.view.callbacks.SetCurrentJokeCallback
import fr.iut.jokapp.viewmodel.ApiViewModel

class FavoriteJokesActivity : AppCompatActivity(), SetCurrentJokeCallback {

    private lateinit var apiViewModel: ApiViewModel

    private var currentJoke : Joke? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_favorite_jokes)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJoke)
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        recyclerView.adapter = RecyclerViewAdapterJoke(JokeDatabase.getInstance().jokeDAO().getAll().toModels(), this)

        setSupportActionBar(findViewById(R.id.toolBarFavoriteJokes))

        apiViewModel = ViewModelProvider(this).get(fr.iut.jokapp.viewmodel.ApiViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        setupMenu()
    }

    private fun setupMenu() {
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_favorite_joke, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem) : Boolean  =
                when (menuItem.itemId) {
                    R.id.action_delete_favorite -> {
                        if(currentJoke != null) {
                            apiViewModel.deleteJoke(currentJoke)
                        }
                        true
                    }
                    else -> {
                        true
                    }
                }
        }, this, Lifecycle.State.RESUMED)
    }

    override fun setCurrentJoke(joke : Joke?) {
        currentJoke = joke
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, FavoriteJokesActivity::class.java)
    }


}