package com.example.appmasterdetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimesAdapter(
    private val animes: List<Anime>,
    private val context: Context,
    private val click: (anime: Anime) -> Unit
) : RecyclerView.Adapter<AnimesAdapter.AnimesViewHolder>() {

    inner class AnimesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animeName: TextView = itemView.findViewById(R.id.animeName)
        val animeAuthor: TextView = itemView.findViewById(R.id.animeAuthor)
        val animeImage: ImageView = itemView.findViewById(R.id.animeImage)

        fun bind(anime: Anime) {
            animeName.text = anime.animeName
            animeAuthor.text = anime.animeAuthor
            animeImage.setImageResource(anime.animeImage)
            itemView.setOnClickListener {
                click(anime)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return AnimesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    override fun onBindViewHolder(holder: AnimesViewHolder, position: Int) {
        val anime = animes[position]
        holder.bind(anime)
    }
}
