import com.google.gson.Gson

var gson = Gson()

fun main() {

    val listaPokemon = ObtenerPokemonRequest.get()

    listaPokemon.cargarListaPokemon()

    listaPokemon.imprimirPokemons()

    println("¿Escribe el nombre del Pokemon que quieres buscar?")
    val nombreBuscado = readLine()
    nombreBuscado?.let {
        val listaPokemonFiltrada = listaPokemon.buscarPokemonPorNombre(it)
        listaPokemonFiltrada.imprimirPokemons()
    }

    println("¿Escribe el tipo que quieres buscar?")
    val tipoBuscado = readLine()
    tipoBuscado?.let {
        val listaPokemonFiltrada = listaPokemon.buscarPokemonPorTipo(it)
        listaPokemonFiltrada.imprimirPokemons()
    }
}