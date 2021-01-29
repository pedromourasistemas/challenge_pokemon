package br.com.challenge_pokemon.model

data class Pokemon (
    var id: Int? = 0,
    var name: String? = null,
    var photo: String? = null,
    var height: Int? = 0,
    var weight: Int? = 0,
    var life: Int? = 0,
    var velocity: Int? = 0,
    var attack: Int? = 0,
    var defense: Int? = 0,
    var defense_special: Int? = 0,
    var attack_special: Int? = 0
)