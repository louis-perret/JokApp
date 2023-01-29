package fr.iut.jokapp.view.fragments.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.Flag

class FragmentBlacklist : Fragment() {

    private lateinit var checkBoxNsfw: CheckBox
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

        return view
    }

    fun getAllFlags() : Flag {
        return Flag(checkBoxNsfw.isChecked, checkBoxReligious.isChecked, checkBoxPolitical.isChecked, checkBoxRacist.isChecked, checkBoxSexist.isChecked, checkBoxExplicit.isChecked)
    }
}