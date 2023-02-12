package fr.iut.jokapp.view.callbacks

import fr.iut.jokapp.repository.entity.JokeEntity

// Callback for deleting favorite jokes
interface OnDeleteJokeListener {

    public fun deleteJoke(joke : JokeEntity?, position : Int)
}