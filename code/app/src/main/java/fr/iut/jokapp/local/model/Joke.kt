package fr.iut.jokapp.local.model

data class Joke(private var formatVersion: String,
                private var category: String,
                private var type: String,
                private var joke: String,
                private var flags: MutableList<Boolean>,
                private var lang: String
) {
}