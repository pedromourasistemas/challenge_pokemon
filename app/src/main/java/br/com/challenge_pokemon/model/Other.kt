package br.com.challenge_pokemon.model

import com.google.gson.annotations.SerializedName

data class Other (
    @SerializedName("official-artwork")
    var official_artwork: OfficialArtwork? = null
)