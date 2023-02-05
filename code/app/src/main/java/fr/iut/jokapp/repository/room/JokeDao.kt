package fr.iut.jokapp.repository.room

import androidx.room.*
import fr.iut.jokapp.repository.entity.JokeEntity

@Dao
interface JokeDao {

    @Query("SELECT * FROM jokes")
    fun getAll(): List<JokeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJoke(joke : JokeEntity)

    @Delete
    suspend fun delete(joke : JokeEntity)
}