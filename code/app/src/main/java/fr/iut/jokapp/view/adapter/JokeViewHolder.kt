package fr.iut.jokapp.view.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.repository.entity.JokeEntity
import fr.iut.jokapp.view.callbacks.OnDeleteJokeListener

class JokeViewHolder(private var itemView : View,  private var listener : OnDeleteJokeListener) : ViewHolder(itemView) {

    private lateinit var joke : JokeEntity
    private var textViewTypeJoke : TextView
    private var textViewLangJoke : TextView
    private var textViewTextJoke : TextView
    private var textViewTextJokeAnswer : TextView
    private var textViewTextJokeCategory : TextView
    private var cardViewJokeViewHolder : CardView
    private var imageButton : ImageButton

    init {
        with(itemView) {
            textViewTypeJoke = findViewById(R.id.typeJoke)
            textViewLangJoke = findViewById(R.id.langJoke)
            textViewTextJoke = findViewById(R.id.textJoke)
            textViewTextJokeAnswer = findViewById(R.id.textJokeAnswer)
            textViewTextJokeCategory = findViewById(R.id.textJokeCategory)
            cardViewJokeViewHolder = findViewById(R.id.cardViewJokeViewHolder)
            imageButton = findViewById(R.id.buttonDeleteJoke)
            imageButton.setOnClickListener() { listener.deleteJoke(joke, adapterPosition)}
        }
    }

    fun bind(joke : JokeEntity) {
        this.joke = joke
        with(joke) {
            textViewTypeJoke.text = type
            textViewLangJoke.text = lang.toString()
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

            var color : Int
            when(category){
                AvailableCategories.Programming.toString() -> {
                    color = R.color.colorProgramming
                }
                AvailableCategories.Misc.toString() -> {
                    color = R.color.colorMisc
                }
                AvailableCategories.Dark.toString() -> {
                    color = R.color.colorDark
                }
                AvailableCategories.Pun.toString() -> {
                    color =R.color.colorPun
                }
                AvailableCategories.Spooky.toString() -> {
                    color = R.color.colorSpooky
                }
                AvailableCategories.Christmas.toString() -> {
                    color = R.color.colorChristmas
                }
                else -> {
                    color =R.color.colorAny
                }
            }
            cardViewJokeViewHolder.setCardBackgroundColor(
                ContextCompat.getColor(itemView.context, color)
            )

        }

    }
}