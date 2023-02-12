package fr.iut.jokapp.repository.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.iut.jokapp.repository.converter.ListAvailableCategoriesToString
import fr.iut.jokapp.repository.converter.AvailableLanguagesToInt
import fr.iut.jokapp.repository.entity.JokeEntity

private const val JOKE_DB_FILENAME = "joke.db"

// Represent the access to the database
@Database(entities = [JokeEntity::class], version = 1)
@TypeConverters(AvailableLanguagesToInt::class)
abstract class JokeDatabase : RoomDatabase() {

    // Retrieve the dao in order to do request to the bd
    abstract fun jokeDAO() : JokeDao

    companion object {
        private lateinit var application: Application

        @Volatile
        private var instance : JokeDatabase? = null

        // Return an instance of JokeDatabase as a singleton
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

        // Initialize the creation of the database
        @Synchronized
        fun initialize(app: Application) {
            if (::application.isInitialized)
                throw RuntimeException("the database must not be initialized twice")

            application = app
        }
    }
}