package fr.iut.jokapp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import fr.iut.jokapp.R
import fr.iut.jokapp.view.callbacks.DisplayJokeCallback
import fr.iut.jokapp.view.fragments.FragmentDisplayJoke
import fr.iut.jokapp.view.fragments.FragmentJokeOptions
import fr.iut.jokapp.viewmodel.ApiViewModel

class GenerateJokePageActivity : AppCompatActivity(), DisplayJokeCallback {


    private lateinit var fragmentOptionsJoke : FragmentJokeOptions
    private lateinit var fragmentDisplayJoke: FragmentDisplayJoke
    private lateinit var apiViewModel: ApiViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_generate_joke)

        if(supportFragmentManager.findFragmentById(R.id.fragmentOptions) == null) {
            fragmentOptionsJoke = FragmentJokeOptions()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentOptions, fragmentOptionsJoke)
                .commit()
        }

        if(supportFragmentManager.findFragmentById(R.id.fragmentDisplayJoke) == null) {
            fragmentDisplayJoke = FragmentDisplayJoke(this)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentDisplayJoke, fragmentDisplayJoke)
                .commit()
        }

        apiViewModel = ViewModelProvider(this).get(fr.iut.jokapp.viewmodel.ApiViewModel::class.java)
        apiViewModel.joke.observe(this) {
            val jokeToDisplay = apiViewModel.joke.value
            if(jokeToDisplay != null) {
                fragmentDisplayJoke.setCurrentJoke(jokeToDisplay)
            }
        }
        //findViewById<Button>(R.id.buttonJoke).setOnClickListener { apiViewModel.getAnyJoke() }
    }

    override fun generateJoke() {
        val categories = fragmentOptionsJoke.getAllChoosenCategories()
        if(categories.isNotEmpty()) apiViewModel.getAnyJoke(categories)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, GenerateJokePageActivity::class.java)
    }

}