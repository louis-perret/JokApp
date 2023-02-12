package fr.iut.jokapp.view.fragments.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.AvailableCategories
import fr.iut.jokapp.view.JokAppApplication

class FragmentFilterCategory() : Fragment() {

    private val ISFIRSTRENDER = "isFirstRender"

    private var checkBoxAny: CheckBox? = null
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
        val view = inflater.inflate(R.layout.fragment_filter_category, container, false)
        with(view) {
            checkBoxAny = findViewById(R.id.checkboxAny)
            checkBoxProgramming = findViewById(R.id.checkboxProgramming)
            checkBoxMisc = findViewById(R.id.checkboxMisc)
            checkBoxDark = findViewById(R.id.checkboxDark)
            checkBoxPun = findViewById(R.id.checkboxPun)
            checkBoxSpooky = findViewById(R.id.checkboxSpooky)
            checkBoxChristmas = findViewById(R.id.checkboxChristmas)
        }

        val preferences = requireContext().getSharedPreferences(JokAppApplication.NAMESHAREDPREFERENCES, 0)
        with(preferences) {
            checkBoxProgramming.isChecked = getBoolean(JokAppApplication.ISCHECKEDPROGRAMMING, false)
            checkBoxMisc.isChecked = getBoolean(JokAppApplication.ISCHECKEDMISC, false)
            checkBoxDark.isChecked = getBoolean(JokAppApplication.ISCHECKEDDARK, false)
            checkBoxPun.isChecked = getBoolean(JokAppApplication.ISCHECKEDPUN, false)
            checkBoxSpooky.isChecked = getBoolean(JokAppApplication.ISCHECKEDSPOOKY, false)
            checkBoxChristmas.isChecked = getBoolean(JokAppApplication.ISCHECKEDCHRISTMAS, false)
        }

        checkBoxAny?.setOnClickListener { setTheCheckedProperty(!(it as CheckBox).isChecked) }
        if(!checkBoxAny?.isChecked!! && !checkBoxProgramming.isChecked && !checkBoxMisc.isChecked && !checkBoxDark.isChecked && !checkBoxPun.isChecked && !checkBoxSpooky.isChecked && !checkBoxChristmas.isChecked) {
            checkBoxAny?.isChecked = true
            setTheCheckedProperty(false)
        }



        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(ISFIRSTRENDER, false)
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        super.onPause()
    }
    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        with(requireContext().getSharedPreferences(JokAppApplication.NAMESHAREDPREFERENCES, 0).edit()) {
            putBoolean(JokAppApplication.ISCHECKEDPROGRAMMING, checkBoxProgramming.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDMISC, checkBoxMisc.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDDARK, checkBoxDark.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDPUN, checkBoxPun.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDSPOOKY, checkBoxSpooky.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDCHRISTMAS, checkBoxChristmas.isChecked)
            apply()
        }
        super.onDestroy()
    }
    fun getAllChoosenCategories(): List<AvailableCategories> {
        var ans: MutableList<AvailableCategories> = ArrayList()
        if(checkBoxAny == null || checkBoxAny?.isChecked!!) {
            ans.add(AvailableCategories.Any)
        }
        else {
            if(checkBoxProgramming.isChecked) ans.add(AvailableCategories.Programming)
            if(checkBoxMisc.isChecked) ans.add(AvailableCategories.Misc)
            if(checkBoxDark.isChecked) ans.add(AvailableCategories.Dark)
            if(checkBoxPun.isChecked) ans.add(AvailableCategories.Pun)
            if(checkBoxSpooky.isChecked) ans.add(AvailableCategories.Spooky)
            if(checkBoxChristmas.isChecked) ans.add(AvailableCategories.Christmas)
        }
        return ans
    }

    private fun setTheCheckedProperty(value : Boolean) {
        checkBoxProgramming.isEnabled = value
        checkBoxMisc.isEnabled = value
        checkBoxDark.isEnabled = value
        checkBoxPun.isEnabled = value
        checkBoxSpooky.isEnabled = value
        checkBoxChristmas.isEnabled = value
    }
}