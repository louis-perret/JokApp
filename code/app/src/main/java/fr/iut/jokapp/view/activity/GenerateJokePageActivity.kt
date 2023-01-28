package fr.iut.jokapp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import fr.iut.jokapp.R
import fr.iut.jokapp.view.callbacks.DisplayJokeCallback
import fr.iut.jokapp.view.fragments.FragmentDisplayJoke
import fr.iut.jokapp.view.fragments.FragmentJokeOptions
import fr.iut.jokapp.viewmodel.ApiViewModel

class GenerateJokePageActivity : AppCompatActivity(), DisplayJokeCallback {


    private lateinit var fragmentOptionsJoke : FragmentJokeOptions
    private lateinit var fragmentDisplayJoke: FragmentDisplayJoke
    private lateinit var apiViewModel: ApiViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_generate_joke)

        setSupportActionBar(findViewById(R.id.toolBarGenerateJoke))
        if(savedInstanceState != null) {
            fragmentOptionsJoke = supportFragmentManager.findFragmentById(R.id.fragmentOptions) as FragmentJokeOptions
            fragmentDisplayJoke = supportFragmentManager.findFragmentById(R.id.fragmentDisplayJoke) as FragmentDisplayJoke
        }
        if(supportFragmentManager.findFragmentById(R.id.fragmentOptions) == null) {
            fragmentOptionsJoke = FragmentJokeOptions()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentOptions, fragmentOptionsJoke)
                .commit()
        }
        else{

            Log.i("OnCreate", "Fragment options récupéré")
        }

        if(supportFragmentManager.findFragmentById(R.id.fragmentDisplayJoke) == null) {
            fragmentDisplayJoke = FragmentDisplayJoke(this)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentDisplayJoke, fragmentDisplayJoke)
                .commit()
        }
        else{

            Log.i("OnCreate", "Fragment options récupéré")
        }

        apiViewModel = ViewModelProvider(this).get(fr.iut.jokapp.viewmodel.ApiViewModel::class.java)
        apiViewModel.joke.observe(this) {
            val jokeToDisplay = apiViewModel.joke.value
            if(jokeToDisplay != null) {
                fragmentDisplayJoke.setCurrentJoke(jokeToDisplay)
            }
        }
        //findViewById<Button>(R.id.buttonJoke).setOnClickListener { apiViewModel.getAnyJoke() }
    }

    override fun onStart() {
        super.onStart()
        setupMenu()
    }

    private fun setupMenu() {
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_generate_joke, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                /*return when (menuItem.itemId) {
                    R.id.menu_item_new_dog -> {
                        addNewDog()
                        true
                    }
                    else -> false
                }*/
                return true
            }
        }, this, Lifecycle.State.RESUMED)
    }

    override fun generateJoke() {
        try {
            val categories = fragmentOptionsJoke.getAllChoosenCategories()
            val choosenLanguage = fragmentOptionsJoke.getChoosenLanguage()
            if (categories.isNotEmpty()) apiViewModel.getJoke(categories, choosenLanguage)
        }
        catch (e: Exception) {
            println(e.message)
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, GenerateJokePageActivity::class.java)
    }

}