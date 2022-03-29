import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

var gson = Gson()
fun main() {

    //Crear cliente
    var client = OkHttpClient()

    //Hacer llamada a la url indicada
    var request = Request.Builder().url("https://pokeapi.co/api/v2/pokemon/1").build()

    //Hacer la peticion de la llamada
    val response = client.newCall(request).execute()

    //Mostrar la peticion si no da error
    if(response.isSuccessful) {
        //Transfroma a Gson
        response.body?.string().let { responseBody ->
            val pokemon = gson.fromJson(responseBody, Pokemon::class.java)
            println(pokemon.decirNombreYTipo())
        }
    }else
        println("Algo ha ido mal")
}