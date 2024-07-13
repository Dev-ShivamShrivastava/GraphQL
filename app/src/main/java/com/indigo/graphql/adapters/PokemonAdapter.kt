package com.indigo.graphql.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indigo.graphql.databinding.ItemPokemonBinding
import com.indigo.graphql.model.Pokemon

class PokemonAdapter: RecyclerView.Adapter<PokemonAdapter.PokemonHolder>() {
   private var pokemonList = listOf<Pokemon>()

    class PokemonHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        return PokemonHolder(ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount()= pokemonList.size

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
       holder.binding.apply {
           tvPokemon.text ="Name:- ${pokemonList[position].name}"
           tvPokemonHeight.text = "Height:- ${pokemonList[position].height}"
       }
    }

    fun setData(pokemonList: List<Pokemon>){
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }
}