package br.com.challenge_pokemon

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.challenge_pokemon.model.Pokemon
import br.com.challenge_pokemon.model.PokemonDTO
import br.com.challenge_pokemon.services.ServicesPokemon
import br.com.challenge_pokemon.utils.NetworkUtils
import br.com.challenge_pokemon.utils.StringUtils.Companion.URL_BASE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    //region Attributes

    var pokemonResponse: MutableLiveData<Pokemon> = MutableLiveData()
    var pokemonParams: Pokemon? = null

    //endregion

    //region Methods

    fun getPokemon() {
        val retrofitClient = NetworkUtils.getRetrofitInstance(URL_BASE)

        val endpoint = retrofitClient.create(ServicesPokemon::class.java)
        val callback = endpoint.getPokemon()

        callback.enqueue(object : Callback<PokemonDTO> {
            override fun onResponse(call: Call<PokemonDTO>, response: Response<PokemonDTO>) {
                if (response.isSuccessful) {

                    val pokemonResp = response.body()

                    var life: Int? = null
                    var attack: Int? = null
                    var special_attack: Int? = null
                    var defense: Int? = null
                    var special_defense: Int? = null
                    var velocity: Int? = null

                    pokemonResp?.stats?.forEach {
                        if(it.stat?.name.equals("hp")) {
                            life = it.base_stat
                        }

                        if(it.stat?.name.equals("attack")) {
                            attack = it.base_stat
                        }

                        if(it.stat?.name.equals("defense")) {
                            defense = it.base_stat
                        }

                        if(it.stat?.name.equals("special-attack")) {
                            special_attack = it.base_stat
                        }

                        if(it.stat?.name.equals("special-defense")) {
                            special_defense = it.base_stat
                        }

                        if(it.stat?.name.equals("speed")) {
                            velocity = it.base_stat
                        }
                    }

                    var pokemon = Pokemon(pokemonResp?.id, pokemonResp?.name,
                            pokemonResp?.sprites?.other?.official_artwork?.front_default,
                            pokemonResp?.height, pokemonResp?.weight, life, velocity, attack, defense, special_defense, special_attack)

                    pokemonParams = pokemon

                    pokemonResponse.value = pokemon
                }
            }

            override fun onFailure(call: Call<PokemonDTO>, t: Throwable) {
                Toast.makeText(getApplication(), "Ocorreu um erro na requisição!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    //endregion
}