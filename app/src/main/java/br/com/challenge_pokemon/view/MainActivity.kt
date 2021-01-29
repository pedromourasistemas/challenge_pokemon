package br.com.challenge_pokemon.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.challenge_pokemon.R

class MainActivity : AppCompatActivity() {

    //region Override Methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //endregion
}