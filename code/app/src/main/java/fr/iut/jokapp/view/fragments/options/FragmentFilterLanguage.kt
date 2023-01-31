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
        spinnerLanguage?.setSelection(0)
        return view
    }

    fun getChoosenLanguage() : AvailableLanguages{
        if(spinnerLanguage == null) {
            return AvailableLanguages.En
        }
        return spinnerLanguage?.selectedItem as AvailableLanguages
    }
}