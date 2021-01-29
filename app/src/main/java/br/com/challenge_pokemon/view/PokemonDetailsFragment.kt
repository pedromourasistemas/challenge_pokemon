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

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    //endregion

    //region Private Methods

    private fun setUpView() {
        mListRecyclerView = binding?.recyclerView

        var layoutManager = GridLayoutManager(activity, 2)
        mListRecyclerView?.layoutManager = layoutManager
    }

    private fun setUpListeners() {

    }

    private fun initViewModel() {
        var stats: MutableList<Int>? = null

        for (i in 0 until 6) {
            
        }

        viewModel.pokemonParams

        mListRecyclerView?.adapter = PokemonStatsListAdapter()
    }

    //endregion
}