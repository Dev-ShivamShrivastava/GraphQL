package com.indigo.graphql.views.main

import com.indigo.graphql.model.Pokemon
import com.indigo.pokemon.PokemonQuery


fun PokemonQuery.Pokemon_v2_pokemon.toSimplePokemon(): Pokemon {
    return Pokemon(
        height = height?:-1 ,
        name = name,
        id = id,
        order = order ?: -1,
    )
}