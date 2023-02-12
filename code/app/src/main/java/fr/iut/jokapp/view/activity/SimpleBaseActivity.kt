package fr.iut.jokapp.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.iut.jokapp.R

abstract class SimpleBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResId())
    }

    abstract fun getLayoutResId() : Int

    protected fun displayToast(message : Int) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}