package fr.iut.jokapp.view.fragments.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import fr.iut.jokapp.R
import fr.iut.jokapp.network.api.APIRequestParameter

class FragmentTypeOfJoke : Fragment() {

    private var checkBoxSingleJoke : CheckBox? = null
    private var checkBox2PartsJoke : CheckBox? = null

    private val PARAMETERSINGLEJOKE = "single"
    private val PARAMETER2PARTJOKE = "twopart"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_filter_type, container, false)
        with(view) {
            checkBoxSingleJoke = findViewById(R.id.checkBoxSingleJoke)
            checkBox2PartsJoke = findViewById(R.id.checkBox2PartsJoke)
        }

        return view
    }

    fun getChoosenTypes() : APIRequestParameter {
        val parameters = APIRequestParameter()
        if(checkBoxSingleJoke == null || checkBoxSingleJoke?.isChecked!!) parameters.addValue(PARAMETERSINGLEJOKE)
        if(checkBox2PartsJoke == null || checkBox2PartsJoke?.isChecked!!) parameters.addValue(PARAMETER2PARTJOKE)
        return parameters
    }
}