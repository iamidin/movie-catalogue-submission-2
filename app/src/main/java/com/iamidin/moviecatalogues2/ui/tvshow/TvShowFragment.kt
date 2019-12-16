package com.iamidin.moviecatalogues2.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.iamidin.moviecatalogues2.R
import com.iamidin.moviecatalogues2.adapter.CardViewAllMovieTvShowAdapter
import com.iamidin.moviecatalogues2.adapter.CardViewMovieTvShowAdapter
import com.iamidin.moviecatalogues2.model.MovieTvShow
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {

    private val list = ArrayList<MovieTvShow>()
    private val listAllMovie = ArrayList<MovieTvShow>()
    private val listPopular = ArrayList<MovieTvShow>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_tv_movies_now_playing.setHasFixedSize(true)
        rv_tv_movie_all.setHasFixedSize(true)
        rv_tv_movies_popular.setHasFixedSize(true)

        list.addAll(getListMoviesNowPlaying())
        showRecyclerCardViewNowPlaying()

        listPopular.addAll(getListMoviesPopular())
        showRecyclerCardViewPopular()

        listAllMovie.addAll(getListMoviesNowPlaying())
        listAllMovie.addAll(getListMoviesPopular())
        showRecyclerCardViewAllMovie()

    }

    private fun getListMoviesNowPlaying(): ArrayList<MovieTvShow> {
        val dataName = resources.getStringArray(R.array.data_name_tv_now_playing)
        val dataDirected = resources.getStringArray(R.array.data_directed_tv_now_playing)
        val dataGenre = resources.getStringArray(R.array.data_genre_tv_now_playing)
        val dataRating = resources.getStringArray(R.array.data_rating_tv_now_playing)
        val dataDescription = resources.getStringArray(R.array.data_description_tv_now_playing)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo_tv_now_playing)

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
        val dataName = resources.getStringArray(R.array.data_name_tv_popular)
        val dataDirected = resources.getStringArray(R.array.data_directed_tv_popular)
        val dataGenre = resources.getStringArray(R.array.data_genre_tv_popular)
        val dataRating = resources.getStringArray(R.array.data_rating_tv_popular)
        val dataDescription = resources.getStringArray(R.array.data_description_tv_popular)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo_tv_popular)

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
        rv_tv_movies_now_playing.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val cardViewHeroAdapter = CardViewMovieTvShowAdapter(list)
        rv_tv_movies_now_playing.adapter = cardViewHeroAdapter
    }

    private fun showRecyclerCardViewPopular() {
        rv_tv_movies_popular.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val cardViewHeroAdapter = CardViewMovieTvShowAdapter(listPopular)
        rv_tv_movies_popular.adapter = cardViewHeroAdapter
    }

    private fun showRecyclerCardViewAllMovie() {
        rv_tv_movie_all.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val cardViewHeroAdapter = CardViewAllMovieTvShowAdapter(listAllMovie)
        rv_tv_movie_all.adapter = cardViewHeroAdapter
    }

}