package fr.iut.jokapp.view.fragments.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import fr.iut.jokapp.R
import fr.iut.jokapp.network.api.APIRequestParameter
import fr.iut.jokapp.view.JokAppApplication

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

        with(requireContext().getSharedPreferences(JokAppApplication.NAMESHAREDPREFERENCES, 0)){
            checkBoxSingleJoke!!.isChecked = getBoolean(JokAppApplication.ISSINGLEJOKE, true)
            checkBox2PartsJoke!!.isChecked = getBoolean(JokAppApplication.ISTWOPARTJOKE, true)
        }
        return view
    }

    override fun onDestroy() {
        with(requireContext().getSharedPreferences(JokAppApplication.NAMESHAREDPREFERENCES, 0).edit()){
            putBoolean(JokAppApplication.ISSINGLEJOKE, checkBoxSingleJoke!!.isChecked)
            putBoolean(JokAppApplication.ISTWOPARTJOKE, checkBox2PartsJoke!!.isChecked)
            apply()
        }
        super.onDestroy()
    }
    fun getChoosenTypes() : APIRequestParameter {
        val parameters = APIRequestParameter()
        if(checkBoxSingleJoke == null || checkBoxSingleJoke?.isChecked!!) parameters.addValue(PARAMETERSINGLEJOKE)
        if(checkBox2PartsJoke == null || checkBox2PartsJoke?.isChecked!!) parameters.addValue(PARAMETER2PARTJOKE)
        return parameters
    }
}