package fr.iut.jokapp.repository

import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.AvailableLanguages
import fr.iut.jokapp.local.modele.Flag
import fr.iut.jokapp.local.modele.Joke

// Interface containing all methods that repository must have to request the api
interface Repository {

    // Get any joke independant of choosen parameters
    suspend fun getAnyJoke(
        categories: List<AvailableCategories>,
        language: AvailableLanguages,
        flags: Flag,
        types: APIRequestParameter
    ) : Joke?
}