package fr.iut.jokapp.repository.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.iut.jokapp.repository.entity.JokeEntity

private const val JOKE_DB_FILENAME = "joke.db"

@Database(entities = [JokeEntity::class], version = 1)
abstract class JokeDatabase : RoomDatabase() {

    abstract fun jokeDAO() : JokeDao

    companion object {
        private lateinit var application: Application

        @Volatile
        private var instance : JokeDatabase? = null

        fun getInstance(): JokeDatabase {
            if (::application.isInitialized) {
                if (instance == null)
                    synchronized(this) {
                        if (instance == null) {
                            instance = Room.databaseBuilder(
                                application.applicationContext,
                                JokeDatabase::class.java,
                                JOKE_DB_FILENAME
                            )
                                .allowMainThreadQueries()
                                .build()
                        }
                    }
                return instance!!
            } else
                throw RuntimeException("The database must be first initialized")
        }

        @Synchronized
        fun initialize(app: Application) {
            if (::application.isInitialized)
                throw RuntimeException("the database must not be initialized twice")

            application = app
        }
    }
}