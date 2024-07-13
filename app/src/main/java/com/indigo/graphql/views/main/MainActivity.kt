package com.indigo.graphql.views.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.indigo.graphql.R
import com.indigo.graphql.adapters.PokemonAdapter
import com.indigo.graphql.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainVM: MainVM by viewModels()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { PokemonAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.rvPokemon.adapter = adapter


        lifecycleScope.launch {
            supervisorScope {
                launch {
                    mainVM.pokemonList.collect {

                        if(it.isNotEmpty()){
                            adapter.setData(it)
                        }
                    }
                }
                launch {
                    mainVM.loader.collect{
                        if(it){
                            binding.progressBar.visibility = View.VISIBLE
                        }else{
                            binding.progressBar.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }






}