package fr.iut.jokapp.view.callbacks

import fr.iut.jokapp.local.modele.Joke

interface SetCurrentJokeCallback {
    fun setCurrentJoke(joke : Joke?)
}