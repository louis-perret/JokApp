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

// Represents the UI of the display of favorite jokes
class FavoriteJokesActivity : SimpleBaseActivity(), OnDeleteJokeListener {

    // View-Model
    private lateinit var viewModelJokeApp: ViewModelFavoriteJoke

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelJokeApp = ViewModelProvider(this).get(fr.iut.jokapp.viewmodel.ViewModelFavoriteJoke::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJoke)
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        var adapter = RecyclerViewAdapterJoke(this)
        recyclerView.adapter = adapter

        // To update the recycler view when a element is deleted
        viewModelJokeApp.jokes.observe(this) {
            adapter.submitList(it)
        }
    }

    override fun getLayoutResId() = R.layout.layout_favorite_jokes

    // Delete a joke
    override fun deleteJoke(joke: JokeEntity?, position: Int) {
        try {
            viewModelJokeApp.deleteJoke(joke)
            displayToast(R.string.jokeDeleted)
        }
        catch(e: Exception) {
            displayToast(R.string.jokeDeletedProblem)
        }

    }

    companion object {
        fun getIntent(context: Context) = Intent(context, FavoriteJokesActivity::class.java)
    }




}