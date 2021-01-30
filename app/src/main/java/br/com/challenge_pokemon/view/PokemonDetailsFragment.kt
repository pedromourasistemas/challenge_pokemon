package br.com.challenge_pokemon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.challenge_pokemon.PokemonViewModel
import br.com.challenge_pokemon.adapter.PokemonStatsListAdapter
import br.com.challenge_pokemon.databinding.FragmentPokemonDetailsBinding
import com.squareup.picasso.Picasso

class PokemonDetailsFragment : Fragment() {

    //region Attributes

    private var binding: FragmentPokemonDetailsBinding? = null
    var mListRecyclerView: RecyclerView? = null
    val viewModel: PokemonViewModel by activityViewModels()

    //endregion

    //region Override Methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPokemonDetailsBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpListeners()
        initViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    //endregion

    //region Private Methods

    private fun setUpView() {
        mListRecyclerView = binding?.recyclerView

        val imageUri = viewModel.pokemonParams?.photo

        Picasso.with(activity)
                .load(imageUri)
                .fit()
                .centerCrop()
                //.placeholder(R.drawable.user_placeholder)
                //.error(R.drawable.user_placeholder_error)
                .into(binding?.imgPokemon);

        binding?.namePokemon?.text = viewModel.pokemonParams?.name

        var layoutManager = GridLayoutManager(activity, 2)
        mListRecyclerView?.layoutManager = layoutManager
    }

    private fun setUpListeners() {

    }

    private fun initViewModel() {
        var stats: MutableList<Int> = mutableListOf<Int>()

        for (i in 0 until 6) {
            if (i == 0) {
                stats.add(viewModel.pokemonParams?.life!!)
            }

            if (i == 1) {
                stats.add(viewModel.pokemonParams?.velocity!!)
            }

            if (i == 2) {
                stats.add(viewModel.pokemonParams?.attack!!)
            }

            if (i == 3) {
                stats.add(viewModel.pokemonParams?.defense!!)
            }

            if (i == 4) {
                stats.add(viewModel.pokemonParams?.defense_special!!)
            }

            if (i == 5) {
                stats.add(viewModel.pokemonParams?.attack_special!!)
            }
        }

        if (stats != null) {
            mListRecyclerView?.adapter = PokemonStatsListAdapter(stats!!)
        }
    }

    //endregion
}