package fr.iut.jokapp.repository.room

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.iut.jokapp.repository.entity.JokeEntity

@Dao
interface JokeDao {

    @Query("SELECT * FROM jokes")
    fun getAll(): LiveData<List<JokeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJoke(joke : JokeEntity)

    @Delete
    suspend fun delete(joke : JokeEntity)
}