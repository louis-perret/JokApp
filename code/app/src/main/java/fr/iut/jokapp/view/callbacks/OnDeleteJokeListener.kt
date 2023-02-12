package fr.iut.jokapp.view.callbacks

import fr.iut.jokapp.repository.entity.JokeEntity

interface OnDeleteJokeListener {

    public fun deleteJoke(joke : JokeEntity?, position : Int)
}