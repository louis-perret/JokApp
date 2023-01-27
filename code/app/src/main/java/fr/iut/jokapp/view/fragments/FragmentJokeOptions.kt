package fr.iut.jokapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Categories
import fr.iut.jokapp.local.modele.Joke
import fr.iut.jokapp.viewmodel.ApiViewModel

class FragmentJokeOptions : Fragment() {

    private lateinit var checkBoxAny: CheckBox
    private lateinit var checkBoxProgramming: CheckBox
    private lateinit var checkBoxMisc: CheckBox
    private lateinit var checkBoxDark: CheckBox
    private lateinit var checkBoxPun: CheckBox
    private lateinit var checkBoxSpooky: CheckBox
    private lateinit var checkBoxChristmas: CheckBox

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_joke_options, container, false)
        checkBoxAny = view.findViewById(R.id.checkboxAny)
        checkBoxProgramming = view.findViewById(R.id.checkboxProgramming)
        checkBoxMisc = view.findViewById(R.id.checkboxMisc)
        checkBoxDark = view.findViewById(R.id.checkboxDark)
        checkBoxPun = view.findViewById(R.id.checkboxPun)
        checkBoxSpooky = view.findViewById(R.id.checkboxSpooky)
        checkBoxChristmas = view.findViewById(R.id.checkboxChristmas)

        return view
    }

    fun getAllChoosenCategories(): List<Categories> {
        var ans: MutableList<Categories> = ArrayList()
        if(checkBoxAny.isChecked) {
            ans.add(Categories.Any)
        }
        else {
            if(checkBoxProgramming.isChecked) ans.add(Categories.Programming)
            if(checkBoxMisc.isChecked) ans.add(Categories.Miscellaneous)
            if(checkBoxDark.isChecked) ans.add(Categories.Dark)
            if(checkBoxPun.isChecked) ans.add(Categories.Pun)
            if(checkBoxSpooky.isChecked) ans.add(Categories.Spooky)
            if(checkBoxChristmas.isChecked) ans.add(Categories.Christmas)
        }
        return ans
    }
}