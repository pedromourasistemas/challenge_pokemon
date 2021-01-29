package br.com.challenge_pokemon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.challenge_pokemon.PokemonViewModel
import br.com.challenge_pokemon.R
import br.com.challenge_pokemon.databinding.FragmentPokemonBinding
import com.squareup.picasso.Picasso

class PokemonFragment : Fragment() {

    //region Attributes

    private var binding: FragmentPokemonBinding? = null
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

        binding = FragmentPokemonBinding.inflate(inflater, container, false)
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
        viewModel.getPokemon()
    }

    private fun setUpListeners() {
        binding?.btnDetails?.setOnClickListener {
            findNavController()?.navigate(R.id.PokemonDetailsFragment)
        }
    }

    private fun initViewModel() {
        viewModel.pokemonResponse.observe(requireActivity()) { state ->
            state?.let {
                val imageUri = it.photo

                Picasso.with(activity)
                        .load(imageUri)
                        .fit()
                        .centerCrop()
                        //.placeholder(R.drawable.user_placeholder)
                        //.error(R.drawable.user_placeholder_error)
                        .into(binding?.imgPokemon);

                binding?.txtName?.text = it.name
            }
        }
    }

    //endregion
}