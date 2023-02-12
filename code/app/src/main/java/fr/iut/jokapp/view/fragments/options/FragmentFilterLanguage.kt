package fr.iut.jokapp.view.fragments.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import fr.iut.jokapp.R
import fr.iut.jokapp.local.modele.AvailableLanguages
import fr.iut.jokapp.repository.converter.AvailableLanguagesToInt
import fr.iut.jokapp.view.JokAppApplication

class FragmentFilterLanguage : Fragment() {

    private var spinnerLanguage: Spinner? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_filter_language, container, false)
        spinnerLanguage = view.findViewById(R.id.spinnerLanguages)
        spinnerLanguage?.adapter = ArrayAdapter(view.context, R.layout.spinner_cell_language, AvailableLanguages.values())

       with(requireContext().getSharedPreferences(JokAppApplication.NAMESHAREDPREFERENCES, 0)){
           spinnerLanguage?.setSelection(getInt(JokAppApplication.CHOOSENLANGUAGE, 0))
       }

        return view
    }

    override fun onDestroy() {
        with(requireContext().getSharedPreferences(JokAppApplication.NAMESHAREDPREFERENCES, 0).edit()){
            putInt(JokAppApplication.CHOOSENLANGUAGE, AvailableLanguagesToInt().toOrdinal(spinnerLanguage!!.selectedItem as AvailableLanguages))
            apply()
        }
        super.onDestroy()
    }
    fun getChoosenLanguage() : AvailableLanguages{
        if(spinnerLanguage == null) {
            return AvailableLanguages.En
        }
        return spinnerLanguage?.selectedItem as AvailableLanguages
    }
}