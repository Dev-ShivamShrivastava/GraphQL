package com.indigo.graphql.views.main

import com.indigo.graph.CountriesQuery
import com.indigo.graph.CountryQuery
import com.indigo.graphql.model.DetailedCountry
import com.indigo.graphql.model.Pokemon
import com.indigo.graphql.model.SimpleCountry
import com.indigo.pokemon.PokemonQuery


fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}

fun PokemonQuery.Pokemon_v2_pokemon.toSimplePokemon(): Pokemon {
    return Pokemon(
        height = height?:-1 ,
        name = name,
        id = id,
        order = order ?: -1,
    )
}