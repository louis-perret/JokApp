package fr.iut.jokapp.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import fr.iut.jokapp.R
import fr.iut.jokapp.view.JokAppApplication
import fr.iut.jokapp.view.callbacks.DisplayJokeCallback
import fr.iut.jokapp.view.fragments.FragmentDisplayJoke
import fr.iut.jokapp.view.fragments.options.FragmentBlacklist
import fr.iut.jokapp.view.fragments.options.FragmentFilterCategory
import fr.iut.jokapp.view.fragments.options.FragmentFilterLanguage
import fr.iut.jokapp.view.fragments.options.FragmentTypeOfJoke
import fr.iut.jokapp.viewmodel.ViewModelGenerateJoke

class GenerateJokePageActivity : SimpleBaseActivity(), DisplayJokeCallback {

    private lateinit var apiViewModel: ViewModelGenerateJoke

    private lateinit var fragmentFilterCategory : FragmentFilterCategory
    private lateinit var fragmentFilterLanguage: FragmentFilterLanguage
    private  lateinit var fragmentBlacklist: FragmentBlacklist
    private lateinit var fragmentTypeOfJoke: FragmentTypeOfJoke

    private lateinit var fragmentDisplayJoke: FragmentDisplayJoke

    private var currentDisplayedFragment : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(findViewById(R.id.toolBarGenerateJoke))


        fragmentFilterCategory = FragmentFilterCategory()
        fragmentFilterLanguage = FragmentFilterLanguage()
        fragmentBlacklist = FragmentBlacklist()
        fragmentTypeOfJoke = FragmentTypeOfJoke()
        setFragment(fragmentFilterCategory)

        if(savedInstanceState != null) {
            fragmentDisplayJoke = supportFragmentManager.findFragmentById(R.id.fragmentDisplayJoke) as FragmentDisplayJoke
        }

        if(supportFragmentManager.findFragmentById(R.id.fragmentDisplayJoke) == null) {
            fragmentDisplayJoke = FragmentDisplayJoke()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentDisplayJoke, fragmentDisplayJoke)
                .commit()
        }

        apiViewModel = ViewModelProvider(this).get(fr.iut.jokapp.viewmodel.ViewModelGenerateJoke::class.java)
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

            override fun onMenuItemSelected(menuItem: MenuItem) : Boolean  =
                when (menuItem.itemId) {
                    R.id.action_category -> {
                        setFragment(fragmentFilterCategory)
                        true
                    }
                    R.id.action_language -> {
                        setFragment(fragmentFilterLanguage)
                        true
                    }
                    R.id.action_flags -> {
                        setFragment(fragmentBlacklist)
                        true
                    }
                    R.id.action_type -> {
                        setFragment(fragmentTypeOfJoke)
                        true
                    }
                    R.id.action_favorite -> {
                        apiViewModel.addJoke()
                        if(apiViewModel.joke.value != null) displayToast(R.string.jokeAddedFavorite)
                        else displayToast(R.string.jokeAddedFavoriteProblem)

                        true
                    }
                    else -> {
                        true
                    }
            }
        }, this, Lifecycle.State.RESUMED)
    }

    private fun setFragment(newFragmentToDisplay : Fragment) {
        if(supportFragmentManager.findFragmentById(R.id.fragmentOptions) == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragmentOptions, newFragmentToDisplay).commit()
        }
        else {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentOptions, newFragmentToDisplay).commit()
        }
        currentDisplayedFragment = newFragmentToDisplay
    }

    override fun generateJoke() {
        try {
            val categories = fragmentFilterCategory.getAllChoosenCategories()
            val choosenLanguage = fragmentFilterLanguage.getChoosenLanguage()
            val flags = fragmentBlacklist.getAllFlags()
            val types = fragmentTypeOfJoke.getChoosenTypes()
            if (categories.isNotEmpty()) apiViewModel.getJoke(categories, choosenLanguage, flags, types)
        }
        catch (e: Exception) {
            displayToast(R.string.jokeGenerationProblem)
        }
    }

    override fun getLayoutResId() = R.layout.layout_generate_joke

    companion object {
        fun getIntent(context: Context) = Intent(context, GenerateJokePageActivity::class.java)
    }
}