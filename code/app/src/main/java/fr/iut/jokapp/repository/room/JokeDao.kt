package fr.iut.jokapp.repository.room

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.iut.jokapp.repository.entity.JokeEntity

// Interface allows the request to the bds
@Dao
interface JokeDao {

    // Get all jokes
    @Query("SELECT * FROM jokes")
    fun getAll(): LiveData<List<JokeEntity>>

    // Insert a joke
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJoke(joke : JokeEntity)

    // Delete a joke
    @Delete
    suspend fun delete(joke : JokeEntity)
}