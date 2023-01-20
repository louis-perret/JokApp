package fr.iut.jokapp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import fr.iut.jokapp.R
import fr.iut.jokapp.local.model.Joke
import fr.iut.jokapp.viewmodel.ApiViewModel

class GenerateJokePage : AppCompatActivity() {

    private lateinit var jokeText: TextView
    private lateinit var apiViewModel: ApiViewModel
    private lateinit var buttonShow2PartOfJoke : Button
    private lateinit var textViewSecondPartOfTheJoke : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_generate_joke)
        apiViewModel = ViewModelProvider(this).get(fr.iut.jokapp.viewmodel.ApiViewModel::class.java)
        jokeText = findViewById(R.id.jokeText)
        buttonShow2PartOfJoke = findViewById(R.id.buttonShow2PartOfJoke)
        textViewSecondPartOfTheJoke = findViewById(R.id.secondPartOfTheJoke)
        buttonShow2PartOfJoke.setOnClickListener { textViewSecondPartOfTheJoke.text = apiViewModel.joke.value?.delivery }
        apiViewModel.joke.observe(this) {
            val jokeToDisplay = apiViewModel.joke.value
            if(jokeToDisplay != null) {
                setCurrentJoke(jokeToDisplay)
            }
        }

        findViewById<Button>(R.id.buttonJoke).setOnClickListener { apiViewModel.getAnyJoke() }
    }

    private fun setCurrentJoke(jokeToDisplay : Joke) {
        textViewSecondPartOfTheJoke.text = ""
        if(jokeToDisplay.joke != null){
            buttonShow2PartOfJoke.visibility = View.INVISIBLE
            jokeText.text = jokeToDisplay.joke
        }
        else{
            buttonShow2PartOfJoke.visibility = View.VISIBLE
            jokeText.text = jokeToDisplay.setup
        }
    }

    companion object {

        fun getIntent(context: Context) = Intent(context, GenerateJokePage::class.java)
    }
}