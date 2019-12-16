package com.iamidin.moviecatalogues2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.iamidin.moviecatalogues2.adapter.CardViewMovieTvShowAdapter
import com.iamidin.moviecatalogues2.R
import com.iamidin.moviecatalogues2.adapter.CardViewAllMovieTvShowAdapter
import com.iamidin.moviecatalogues2.model.MovieTvShow
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val list = ArrayList<MovieTvShow>()
    private val listAllMovie = ArrayList<MovieTvShow>()
    private val listPopular = ArrayList<MovieTvShow>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_movies_now_playing.setHasFixedSize(true)
        rv_movie_all.setHasFixedSize(true)
        rv_movies_popular.setHasFixedSize(true)

        list.addAll(getListMoviesNowPlaying())
        showRecyclerCardViewNowPlaying()

        listPopular.addAll(getListMoviesPopular())
        showRecyclerCardViewPopular()

        listAllMovie.addAll(getListMoviesNowPlaying())
        listAllMovie.addAll(getListMoviesPopular())
        showRecyclerCardViewAllMovie()

    }

    private fun getListMoviesNowPlaying(): ArrayList<MovieTvShow> {
        val dataName = resources.getStringArray(R.array.data_name_now_playing)
        val dataDirected = resources.getStringArray(R.array.data_directed_now_playing)
        val dataGenre = resources.getStringArray(R.array.data_genre_now_playing)
        val dataRating = resources.getStringArray(R.array.data_rating_now_playing)
        val dataDescription = resources.getStringArray(R.array.data_description_now_playing)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo_now_playing)

        val listMovie = ArrayList<MovieTvShow>()

        for (position in dataName.indices) {
            val movie = MovieTvShow(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDirected[position],
                dataGenre[position],
                dataRating[position].toFloat(),
                dataDescription[position]
            )
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun getListMoviesPopular(): ArrayList<MovieTvShow> {
        val dataName = resources.getStringArray(R.array.data_name_popular)
        val dataDirected = resources.getStringArray(R.array.data_directed_popular)
        val dataGenre = resources.getStringArray(R.array.data_genre_popular)
        val dataRating = resources.getStringArray(R.array.data_rating_popular)
        val dataDescription = resources.getStringArray(R.array.data_description_popular)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo_popular)

        val listMovie = ArrayList<MovieTvShow>()

        for (position in dataName.indices) {
            val movie = MovieTvShow(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDirected[position],
                dataGenre[position],
                dataRating[position].toFloat(),
                dataDescription[position]
            )
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerCardViewNowPlaying() {
        rv_movies_now_playing.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val cardViewHeroAdapter = CardViewMovieTvShowAdapter(list)
        rv_movies_now_playing.adapter = cardViewHeroAdapter
    }

    private fun showRecyclerCardViewPopular() {
        rv_movies_popular.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val cardViewHeroAdapter = CardViewMovieTvShowAdapter(listPopular)
        rv_movies_popular.adapter = cardViewHeroAdapter
    }

    private fun showRecyclerCardViewAllMovie() {
        rv_movie_all.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val cardViewHeroAdapter = CardViewAllMovieTvShowAdapter(listAllMovie)
        rv_movie_all.adapter = cardViewHeroAdapter
    }

}