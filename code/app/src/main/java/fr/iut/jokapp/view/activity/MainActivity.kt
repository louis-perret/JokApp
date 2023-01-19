package fr.iut.jokapp.view.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import fr.iut.jokapp.R
import fr.iut.jokapp.databinding.ActivityMainBinding
import fr.iut.jokapp.local.model.Joke
import fr.iut.jokapp.repository.RepositoryAPI
import fr.iut.jokapp.viewmodel.ApiViewModel

class MainActivity : AppCompatActivity() {

    //private lateinit var appBarConfiguration: AppBarConfiguration
    //private lateinit var binding: ActivityMainBinding

    private lateinit var jokeText: TextView
    private lateinit var apiViewModel: ApiViewModel
    private lateinit var buttonShow2PartOfJoke : Button
    private lateinit var textViewSecondPartOfTheJoke : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        apiViewModel = ViewModelProvider(this).get(fr.iut.jokapp.viewmodel.ApiViewModel::class.java)
        jokeText = findViewById(R.id.jokeText)
        buttonShow2PartOfJoke = findViewById(R.id.buttonShow2PartOfJoke)
        textViewSecondPartOfTheJoke = findViewById(R.id.secondPartOfTheJoke)
        buttonShow2PartOfJoke.setOnClickListener { textViewSecondPartOfTheJoke.text = apiViewModel.joke.value?.delivery }
        apiViewModel.joke.observe(this) {
            val jokeToDisplay = apiViewModel.joke.value
            if(jokeToDisplay != null) {
                setCurrentJoke(jokeToDisplay)
            }
        }

        findViewById<Button>(R.id.buttonJoke).setOnClickListener { apiViewModel.getAnyJoke() }
        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }

    private fun setCurrentJoke(jokeToDisplay : Joke) {
        textViewSecondPartOfTheJoke.text = ""
        if(jokeToDisplay.joke != null){
            buttonShow2PartOfJoke.visibility = View.INVISIBLE
            jokeText.text = jokeToDisplay.joke
        }
        else{
            buttonShow2PartOfJoke.visibility = View.VISIBLE
            jokeText.text = jokeToDisplay.setup
        }
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}