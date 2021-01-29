package br.com.challenge_pokemon.model

data class PokemonDTO (
    var id: Int? = 0,
    var name: String? = null,
    var height: Int? = 0,
    var weight: Int? = 0,
    var abilities: List<Abilities>? = null,
    var base_experience: Int? = 0,
    var sprites: Sprites? = null,
    var stats: List<Stats>? = null
)