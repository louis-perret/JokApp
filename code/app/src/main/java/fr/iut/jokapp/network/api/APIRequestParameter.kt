package fr.iut.jokapp.network.api

// Class representing a parameter for the web request to the API Joke API
class APIRequestParameter {

    // Values to pass to the request
    private var values: MutableList<String> = ArrayList()

    // Add a value in the list values
    fun addValue(value : String) {
        values.add(value)
    }

    // Turn the values into an acceptable string for the web request
    override fun toString(): String {
        var result = StringBuilder()
        for(value in values){
            result.append(value)
            result.append(",")
        }
        return result.dropLast(1).toString()
    }
}