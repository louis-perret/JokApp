package fr.iut.jokapp.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class JokeEntity(
    @PrimaryKey(autoGenerate = true) private val id: Int
) {
}