package fr.iut.jokapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.room.JokeDatabase
import fr.iut.jokapp.view.callbacks.OnItemClickListener
import fr.iut.jokapp.view.callbacks.SetCurrentJokeCallback

class RecyclerViewAdapterJoke(private var jokeList: List<Joke>, private var listener : SetCurrentJokeCallback) : RecyclerView.Adapter<JokeViewHolder>(), OnItemClickListener{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        JokeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_joke,
                parent,
                false
            ), this
        )



    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) = holder.bind(jokeList.get(position))


    override fun getItemCount() = jokeList.size

    override fun onClick(joke: Joke?, position: Int) {
        notifyItemChanged(position)
        listener.setCurrentJoke(joke)
    }
}