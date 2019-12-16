package com.iamidin.moviecatalogues2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.iamidin.moviecatalogues2.model.MovieTvShow
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as MovieTvShow

        val imgViewCover: ImageView = img_movie_cover_photo
        Glide.with(this)
            .load(movie.photo)
            .into(imgViewCover)

        val imgView: ImageView = img_movie_photo
        Glide.with(this)
            .load(movie.photo)
            .into(imgView)

        val txtTitle: TextView = tv_movie_name
        txtTitle.text = movie.name

        val txtDirected: TextView = tv_movie_directed
        txtDirected.text = movie.directed

        val rbRating: RatingBar = rb_rating
        rbRating.rating = movie.rating

        val txtGenre: TextView = tv_movie_genre
        txtGenre.text = movie.genre

        val txtDescription: TextView = tv_movie_description
        txtDescription.text = movie.description

        val txtMovieRating: TextView = tv_movie_rating
        txtMovieRating.text = movie.rating.toString()

        btn_back.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_back -> {
                onBackPressed()
            }
        }
    }

}
