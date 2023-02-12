package fr.iut.jokapp.view.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import fr.iut.jokapp.R

// Represents the home page of the app
class HomeActivity : SimpleBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.buttonGenerateJoke).setOnClickListener { startActivity(GenerateJokePageActivity.getIntent(this)) }
        findViewById<Button>(R.id.buttonShowFavorites).setOnClickListener { startActivity(FavoriteJokesActivity.getIntent(this)) }
    }

    override fun getLayoutResId() = R.layout.layout_home
}