package fr.iut.jokapp.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import fr.iut.jokapp.R
import fr.iut.jokapp.local.model.Joke
import fr.iut.jokapp.viewmodel.ApiViewModel

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_home)
        findViewById<Button>(R.id.buttonGenerateJoke).setOnClickListener { startActivity(GenerateJokePage.getIntent(this)) }
    }


}