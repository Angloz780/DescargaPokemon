import com.google.gson.Gson
import kotlin.system.exitProcess

var gson = Gson()

fun main() {

    val listaPokemon = ObtenerPokemonRequest.get()

    listaPokemon.forEach {
        println(it.decirNombreYTipo())
    }

    println("Escribe el nombre del Pokemon que quieres buscar")

    val nombreBuscado = readLine()

    nombreBuscado?.let {
        //TODO Muestrame al Pokemon de ese nombre. Si no hay, dime que hay

        var pokemonEncontrado : Pokemon? = null

        listaPokemon.forEach {
            if(nombreBuscado.contains(it.name))
                pokemonEncontrado = it
        }
        pokemonEncontrado?.let {
            println(it.decirNombreYTipo())
        }?: run{
            println("Ese Pokemon no existe")
        }
    }

    /* Forma 2
    val listaFiltrada = listaPokemon.filter{
        it.name == nombreBuscado
        }

    if(listaFiltrada.isEmpty()){
        println("No se ha encontrado a ese Pokemon")
    }else{
        listaFiltrada.forEach{
            println(it.decirNombreYTipo())
        }
    }
}
     */

    println("Escribe el tipo que quieres buscar")
    val tipoBuscado = readLine()

    tipoBuscado?.let {
        //TODO Muestrame todos los Pokemon de ese tipo. Si no hay, dime que hay

        val listaFiltrada = mutableListOf<Pokemon>()

        listaPokemon.forEach { list ->

            list.types.forEach { tipo ->

                if (tipoBuscado == tipo.type.name) {

                    listaFiltrada.add(list)
                }
            }
        }
        if (listaFiltrada.isEmpty()) {
            println("El Pokemon no tiene este tipo")
        } else {
            listaFiltrada.forEach {
                println(it.decirNombreYTipo())
            }
        }
    }
}