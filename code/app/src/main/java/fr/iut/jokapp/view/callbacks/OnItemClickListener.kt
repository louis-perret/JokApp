package fr.iut.jokapp.view.callbacks

import fr.iut.jokapp.local.modele.Joke

interface OnItemClickListener {
    fun onClick(joke : Joke?, position : Int)
}