package fr.iut.jokapp.view.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import fr.iut.jokapp.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_home)
        findViewById<Button>(R.id.buttonGenerateJoke).setOnClickListener { startActivity(GenerateJokePageActivity.getIntent(this)) }
        findViewById<Button>(R.id.buttonShowFavorites).setOnClickListener { startActivity(FavoriteJokesActivity.getIntent(this)) }
    }


}