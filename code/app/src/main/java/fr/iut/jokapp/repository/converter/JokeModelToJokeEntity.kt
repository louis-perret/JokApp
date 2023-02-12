package fr.iut.jokapp.repository.converter

import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.AvailableLanguages
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.entity.JokeEntity

/// Extension method to convert a model joke to an entity joke
fun Joke.toEntity() : JokeEntity {
 var lang : AvailableLanguages = AvailableLanguages.En
 for(l in AvailableLanguages.values()) {
  if (l.toString().equals(this.lang)) {
    lang = l
  }
 }
 return JokeEntity(this.id, this.formatVersion, this.category, this.type, this.joke, this.setup, this.delivery, this.flags, lang)
}

/// Extension method to convert a list of model joke to a list of entity joke
fun List<Joke>.toEntity() : List<JokeEntity> {
 val result = ArrayList<JokeEntity>()
 for (joke in this) {
  result.add(joke.toEntity())
 }
 return result
}

/// Extension method to convert an entity joke to a model joke
fun JokeEntity.toModel() = Joke(this.id, this.formatVersion, this.category!!, this.type, this.joke, this.setup, this.delivery, this.flags!!, this.lang.toString())

/// Extension method to convert a list of entity joke to list of a model joke
fun List<JokeEntity>.toModels() : List<Joke> {
 val result = ArrayList<Joke>()
 for (joke in this) {
  result.add(joke.toModel())
 }
 return result
}