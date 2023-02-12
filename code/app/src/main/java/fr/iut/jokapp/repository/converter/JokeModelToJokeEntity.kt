package fr.iut.jokapp.repository.converter

import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.AvailableLanguages
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.repository.entity.JokeEntity

fun Joke.toEntity() : JokeEntity {
 var lang : AvailableLanguages = AvailableLanguages.En
 for(l in AvailableLanguages.values()) {
  if (l.toString().equals(this.lang)) {
    lang = l
  }
 }
 return JokeEntity(this.id, this.formatVersion, this.category, this.type, this.joke, this.setup, this.delivery, this.flags, lang)
}

fun List<Joke>.toEntity() : List<JokeEntity> {
 val result = ArrayList<JokeEntity>()
 for (joke in this) {
  result.add(joke.toEntity())
 }
 return result
}

fun JokeEntity.toModel() = Joke(this.id, this.formatVersion, this.category!!, this.type, this.joke, this.setup, this.delivery, this.flags!!, this.lang.toString())

fun List<JokeEntity>.toModels() : List<Joke> {
 val result = ArrayList<Joke>()
 for (joke in this) {
  result.add(joke.toModel())
 }
 return result
}