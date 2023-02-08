package fr.iut.jokapp.view.adapter

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.view.callbacks.OnItemClickListener
import fr.iut.jokapp.view.callbacks.SetCurrentJokeCallback

class JokeViewHolder(private var itemView : View,  private var listener : OnItemClickListener) : ViewHolder(itemView) {

    private var joke : Joke? = null
    private var textViewTypeJoke : TextView
    private var textViewLangJoke : TextView
    private var textViewTextJoke : TextView
    private var textViewTextJokeAnswer : TextView
    private var textViewTextJokeCategory : TextView
    private var cardViewJokeViewHolder : CardView

    private var currentColor : Int = 0
    private var colorNotClicked : Int = 0
    private var colorClicked : Int = 0

    init {
        with(itemView) {
            textViewTypeJoke = findViewById(R.id.typeJoke)
            textViewLangJoke = findViewById(R.id.langJoke)
            textViewTextJoke = findViewById(R.id.textJoke)
            textViewTextJokeAnswer = findViewById(R.id.textJokeAnswer)
            textViewTextJokeCategory = findViewById(R.id.textJokeCategory)
            cardViewJokeViewHolder = findViewById(R.id.cardViewJokeViewHolder)
        }
        cardViewJokeViewHolder.setOnClickListener() {
            if(currentColor == colorNotClicked) {
                currentColor = colorClicked
            }
            else {
                currentColor = colorNotClicked
            }
            listener.onClick(joke,adapterPosition)
        }

    }

    fun bind(joke : Joke) {
        this.joke = joke
        with(joke) {
            textViewTypeJoke.text = type
            textViewLangJoke.text = lang
            textViewTextJokeCategory.text = category
            if(type.equals("single")) {
                textViewTextJoke.text = joke.joke
                textViewTextJokeAnswer.text = ""
                textViewTextJokeAnswer.visibility = View.INVISIBLE
            }
            else {
                textViewTextJoke.text = setup
                textViewTextJokeAnswer.text = delivery
                textViewTextJokeAnswer.visibility = View.VISIBLE
            }

            when(category){
                AvailableCategories.Programming.toString() -> {
                    colorNotClicked = R.color.colorProgramming
                    colorClicked = R.color.colorProgrammingClicked
                }
                AvailableCategories.Misc.toString() -> {
                    colorNotClicked = R.color.colorMisc
                    colorNotClicked = R.color.colorMiscClicked
                }
                AvailableCategories.Dark.toString() -> {
                    colorNotClicked = R.color.colorDark
                    colorClicked = R.color.colorDarkClicked
                }
                AvailableCategories.Pun.toString() -> {
                    colorNotClicked = R.color.colorPun
                    colorClicked = R.color.colorPunClicked
                }
                AvailableCategories.Spooky.toString() -> {
                    colorNotClicked = R.color.colorSpooky
                    colorClicked = R.color.colorSpookyClicked
                }
                AvailableCategories.Christmas.toString() -> {
                    colorNotClicked = R.color.colorChristmas
                    colorClicked = R.color.colorChristmasClicked
                }
                else -> {
                    colorNotClicked = R.color.colorAny
                    colorClicked = R.color.colorAnyClicked
                }
            }

            currentColor = colorNotClicked
            cardViewJokeViewHolder.setCardBackgroundColor(
                ContextCompat.getColor(itemView.context, currentColor)
            )

        }

    }
}