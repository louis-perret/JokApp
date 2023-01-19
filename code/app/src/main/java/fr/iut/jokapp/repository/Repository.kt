package fr.iut.jokapp.repository

import fr.iut.jokapp.local.model.Joke

interface Repository {

    suspend fun getAnyJoke() : Joke?
}