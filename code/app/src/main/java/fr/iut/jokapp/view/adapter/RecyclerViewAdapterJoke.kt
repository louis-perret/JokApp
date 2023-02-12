package fr.iut.jokapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.entity.JokeEntity
import fr.iut.jokapp.view.callbacks.OnDeleteJokeListener

// Recycler view of the app
class RecyclerViewAdapterJoke(private var listener : OnDeleteJokeListener) : ListAdapter<JokeEntity, JokeViewHolder>(DiffUtilJokeCallback), OnDeleteJokeListener{

    // To compare if two jokes are similar in order to know which element must be updated
    private object DiffUtilJokeCallback : DiffUtil.ItemCallback<JokeEntity>() {
        override fun areItemsTheSame(oldItem: JokeEntity, newItem: JokeEntity) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: JokeEntity, newItem: JokeEntity) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        JokeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_joke,
                parent,
                false
            ), this
        )



    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) = holder.bind(getItem(position))

    override fun deleteJoke(joke: JokeEntity?, position: Int) {
        listener.deleteJoke(joke, position)
        notifyItemChanged(position)
    }
}