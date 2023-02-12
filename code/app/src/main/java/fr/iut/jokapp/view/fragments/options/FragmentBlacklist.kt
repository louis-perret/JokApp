package fr.iut.jokapp.view.fragments.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Flag
import fr.iut.jokapp.view.JokAppApplication

// Represents the fragment for the different flags (blacklist) that we can choose
class FragmentBlacklist : Fragment() {

    private var checkBoxNsfw: CheckBox? = null
    private lateinit var checkBoxReligious: CheckBox
    private lateinit var checkBoxPolitical: CheckBox
    private lateinit var checkBoxRacist: CheckBox
    private lateinit var checkBoxSexist: CheckBox
    private lateinit var checkBoxExplicit: CheckBox

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_filter_blacklist, container, false)
        with(view) {
            checkBoxNsfw = findViewById(R.id.checkboxNsfw)
            checkBoxReligious = findViewById(R.id.checkboxReligious)
            checkBoxPolitical = findViewById(R.id.checkboxPolitical)
            checkBoxRacist = findViewById(R.id.checkboxRacist)
            checkBoxSexist = findViewById(R.id.checkboxSexist)
            checkBoxExplicit = findViewById(R.id.checkboxExplicit)
        }

        // To retrieve the old values of this fragment when the user came back to the activity GenerateJokePageActivity
        val preferences = requireContext().getSharedPreferences(JokAppApplication.NAMESHAREDPREFERENCES, 0)
        with(preferences) {
            checkBoxNsfw!!.isChecked = getBoolean(JokAppApplication.ISCHECKEDNSFW, false)
            checkBoxReligious.isChecked = getBoolean(JokAppApplication.ISCHECKEDRELIGIOUS, false)
            checkBoxPolitical.isChecked = getBoolean(JokAppApplication.ISCHECKEDPOLITICAL, false)
            checkBoxRacist.isChecked = getBoolean(JokAppApplication.ISCHECKEDRACIST, false)
            checkBoxSexist.isChecked = getBoolean(JokAppApplication.ISCHECKEDSEXIST, false)
            checkBoxExplicit.isChecked = getBoolean(JokAppApplication.ISCHECKEDEXPLICIT, false)
        }
        return view
    }

    fun getAllFlags() : Flag {
        if(checkBoxNsfw == null) return Flag(
            nsfw = false,
            religious = false,
            political = false,
            racist = false,
            sexist = false,
            explicit = false
        )
        return Flag(checkBoxNsfw?.isChecked!!, checkBoxReligious.isChecked, checkBoxPolitical.isChecked, checkBoxRacist.isChecked, checkBoxSexist.isChecked, checkBoxExplicit.isChecked)
    }

    override fun onDestroy() {
        // To save values of this fragment when the user change the displayed fragment
        with(requireContext().getSharedPreferences(JokAppApplication.NAMESHAREDPREFERENCES, 0).edit()) {
            putBoolean(JokAppApplication.ISCHECKEDNSFW, checkBoxNsfw!!.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDRELIGIOUS, checkBoxReligious.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDPOLITICAL, checkBoxPolitical.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDRACIST, checkBoxRacist.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDSEXIST, checkBoxSexist.isChecked)
            putBoolean(JokAppApplication.ISCHECKEDEXPLICIT, checkBoxExplicit.isChecked)
            apply()
        }
        super.onDestroy()
    }
}