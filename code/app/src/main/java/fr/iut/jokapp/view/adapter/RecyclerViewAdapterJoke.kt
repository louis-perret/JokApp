package fr.iut.jokapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.room.JokeDatabase

class RecyclerViewAdapterJoke(private var jokeList: List<Joke>) : RecyclerView.Adapter<JokeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        JokeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_joke,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) = holder.bind(jokeList.get(position))

    override fun getItemCount() = jokeList.size
}