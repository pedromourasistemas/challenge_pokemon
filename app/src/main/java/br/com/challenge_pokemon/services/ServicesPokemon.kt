package br.com.challenge_pokemon.services

import br.com.challenge_pokemon.model.PokemonDTO
import retrofit2.Call
import retrofit2.http.GET

interface ServicesPokemon {

    @GET("pokemon/bulbasaur")
    fun getPokemon(): Call<PokemonDTO>

}