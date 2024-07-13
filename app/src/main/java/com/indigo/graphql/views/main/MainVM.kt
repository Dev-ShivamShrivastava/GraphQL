package com.indigo.graphql.views.main

import androidx.lifecycle.ViewModel
import com.indigo.graphql.model.Pokemon
import com.indigo.graphql.network.NetworkProcess
import com.indigo.graphql.network.Repository
import com.indigo.pokemon.PokemonQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(val repository: Repository) : ViewModel() {

    val pokemonList = MutableSharedFlow<List<Pokemon>>()
    val loader = MutableSharedFlow<Boolean>()


    init {
        getPokemon()
    }

     fun getPokemon() {
        CoroutineScope(Dispatchers.IO).launch {
            loader.emit(true)
            repository.makeApiCall(PokemonQuery()).collect {
                when (it) {
                    is NetworkProcess.Success -> {
                        loader.emit(false)
                        pokemonList.emit(it.data?.pokemon_v2_pokemon?.map { it.toSimplePokemon() } ?: emptyList())
                    }

                    is NetworkProcess.Failure -> {

                    }

                    is NetworkProcess.Loading -> {


                    }
                }
            }
        }

    }
}