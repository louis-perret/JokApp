package fr.iut.jokapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import androidx.fragment.app.Fragment
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.local.modele.AvailableLanguages

class FragmentJokeOptions : Fragment() {

    private lateinit var checkBoxAny: CheckBox
    private lateinit var checkBoxProgramming: CheckBox
    private lateinit var checkBoxMisc: CheckBox
    private lateinit var checkBoxDark: CheckBox
    private lateinit var checkBoxPun: CheckBox
    private lateinit var checkBoxSpooky: CheckBox
    private lateinit var checkBoxChristmas: CheckBox
    private lateinit var spinnerLanguage: Spinner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_joke_options, container, false)
        with(view) {
            checkBoxAny = findViewById(R.id.checkboxAny)
            checkBoxProgramming = findViewById(R.id.checkboxProgramming)
            checkBoxMisc = findViewById(R.id.checkboxMisc)
            checkBoxDark = findViewById(R.id.checkboxDark)
            checkBoxPun = findViewById(R.id.checkboxPun)
            checkBoxSpooky = findViewById(R.id.checkboxSpooky)
            checkBoxChristmas = findViewById(R.id.checkboxChristmas)
            spinnerLanguage = findViewById(R.id.spinnerLanguages)
        }

        spinnerLanguage.adapter = ArrayAdapter(view.context, R.layout.spinner_cell_language, AvailableLanguages.values())
        spinnerLanguage.setSelection(0)
        return view
    }

    fun getAllChoosenCategories(): List<AvailableCategories> {
        var ans: MutableList<AvailableCategories> = ArrayList()
        if(checkBoxAny.isChecked) {
            ans.add(AvailableCategories.Any)
        }
        else {
            if(checkBoxProgramming.isChecked) ans.add(AvailableCategories.Programming)
            if(checkBoxMisc.isChecked) ans.add(AvailableCategories.Miscellaneous)
            if(checkBoxDark.isChecked) ans.add(AvailableCategories.Dark)
            if(checkBoxPun.isChecked) ans.add(AvailableCategories.Pun)
            if(checkBoxSpooky.isChecked) ans.add(AvailableCategories.Spooky)
            if(checkBoxChristmas.isChecked) ans.add(AvailableCategories.Christmas)
        }
        return ans
    }

    fun getChoosenLanguage() : AvailableLanguages{
        return spinnerLanguage.selectedItem as AvailableLanguages
    }
}