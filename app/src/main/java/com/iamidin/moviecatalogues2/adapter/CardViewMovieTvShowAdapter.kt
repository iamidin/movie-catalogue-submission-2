package com.iamidin.moviecatalogues2.adapter

import com.iamidin.moviecatalogues2.model.MovieTvShow
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iamidin.moviecatalogues2.DetailActivity
import com.iamidin.moviecatalogues2.R
import kotlinx.android.synthetic.main.item_cardview_movie_tv_show.view.*


class CardViewMovieTvShowAdapter(private val listMovieTvShow: ArrayList<MovieTvShow>) : RecyclerView.Adapter<CardViewMovieTvShowAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview_movie_tv_show, viewGroup, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listMovieTvShow[position])
    }

    override fun getItemCount(): Int = listMovieTvShow.size

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieTvShow: MovieTvShow) {
            with(itemView) {
                tv_name.text = movieTvShow.name
                tv_directed.text = movieTvShow.directed
                tv_genre.text = movieTvShow.genre
                rb_rating.rating = movieTvShow.rating

                Glide.with(itemView.context)
                    .load(movieTvShow.photo)
                    .into(img_photo)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movieTvShow)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}