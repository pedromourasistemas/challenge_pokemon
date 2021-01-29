package br.com.challenge_pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.challenge_pokemon.R

class PokemonStatsListAdapter(private val stats: List<Int>) : RecyclerView.Adapter<PokemonStatsListAdapter.BookHolder>() {

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val product: Int = stats[position]
        holder.bind(product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view = LayoutInflater.from(parent?.context).inflate(
                R.layout.item_property_pokemon,
                parent,
                false
        )
        return BookHolder(view)
    }

    override fun getItemCount(): Int {
        return stats.size
    }

    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var stat: TextView? = null
        private var value: TextView? = null

        init {
            stat = itemView.findViewById(R.id.name)
            value = itemView.findViewById(R.id.value)
        }

        fun bind(stats: Int) {
            //id?.text = book.id
            //title?.text = book.title
        }
    }
}