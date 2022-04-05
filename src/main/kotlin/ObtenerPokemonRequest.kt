import okhttp3.OkHttpClient
import okhttp3.Request

class ObtenerPokemonRequest {

    companion object {
        fun get(): MutableList<Pokemon> {

            val listaPokemon = mutableListOf<Pokemon>()
            val client = OkHttpClient()

            for (i in 1..9) {
                //Hacer llamada a la url indicada
                val request = Request.Builder().url("https://pokeapi.co/api/v2/pokemon/${i}").build()

                //Hacer la peticion de la llamada
                val response = client.newCall(request).execute()

                //Mostrar la peticion si no da error
                if (response.isSuccessful) {
                    //Transfroma a Gson
                    response.body?.string().let { responseBody ->
                        val pokemon = gson.fromJson(responseBody, Pokemon::class.java)

                        //Escribir solo un Pokemon
                        //println(pokemon.decirNombreYTipo())
                        listaPokemon.add(pokemon)
                    }
                } else
                    println("Algo ha ido mal")
            }
            return listaPokemon
        }
    }
}