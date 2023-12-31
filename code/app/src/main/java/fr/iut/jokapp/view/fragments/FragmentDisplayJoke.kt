package fr.iut.jokapp.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.view.callbacks.DisplayJokeCallback

// Represents the fragment which displayed the joke retrieved by the api
class FragmentDisplayJoke() : Fragment(){

    private lateinit var jokeToDisplay: Joke
    private lateinit var jokeText: TextView
    private lateinit var buttonShow2PartOfJoke : Button
    private lateinit var textViewSecondPartOfTheJoke : TextView
    private var listener: DisplayJokeCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_display_joke, container, false)
        jokeText = view.findViewById(R.id.jokeText)
        buttonShow2PartOfJoke = view.findViewById(R.id.buttonShow2PartOfJoke)
        textViewSecondPartOfTheJoke = view.findViewById(R.id.secondPartOfTheJoke)
        buttonShow2PartOfJoke.setOnClickListener { textViewSecondPartOfTheJoke.text = jokeToDisplay.delivery }

        view.findViewById<Button>(R.id.buttonJoke).setOnClickListener { listener?.generateJoke() }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is DisplayJokeCallback) {
            listener = context
        }
        else {
            throw RuntimeException("$context must implement OnInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun setCurrentJoke(jokeToDisplay : Joke) {
        buttonShow2PartOfJoke.visibility = View.INVISIBLE
        textViewSecondPartOfTheJoke.text = ""
        if(jokeToDisplay.joke == null && jokeToDisplay.setup == null) {
            jokeText.text = getString(R.string.textNoFoundJoke)
        }
        else {
            this.jokeToDisplay = jokeToDisplay
            if(jokeToDisplay.joke != null) {
                jokeText.text = jokeToDisplay.joke
            }
            else{
                buttonShow2PartOfJoke.visibility = View.VISIBLE
                jokeText.text = jokeToDisplay.setup
            }
        }
    }
}