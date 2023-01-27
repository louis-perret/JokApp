package fr.iut.jokapp.repository

import fr.iut.jokapp.local.model.Joke

// Interface containing all methods that repository must have to request the api
interface Repository {

    // Get any joke independant of choosen parameters
    suspend fun getAnyJoke() : Joke?
}