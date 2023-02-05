package fr.iut.jokapp.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Joke

class JokeViewHolder(private var itemView : View) : ViewHolder(itemView) {

    private var textViewTypeJoke : TextView
    private var textViewLangJoke : TextView
    private var textViewTextJoke : TextView
    private var textViewTextJokeAnswer : TextView

    init {
        with(itemView) {
            textViewTypeJoke = findViewById(R.id.typeJoke)
            textViewLangJoke = findViewById(R.id.langJoke)
            textViewTextJoke = findViewById(R.id.textJoke)
            textViewTextJokeAnswer = findViewById(R.id.textJokeAnswer)
        }
    }

    fun bind(joke : Joke) {
        with(joke) {
            textViewTypeJoke.text = type
            textViewLangJoke.text = lang

            if(type.equals("single")) {
                textViewTextJoke.text = joke.joke
                textViewTextJokeAnswer.text = ""
            }
            else {
                textViewTextJoke.text = setup
                textViewTextJokeAnswer.text = delivery
            }
        }

    }
}