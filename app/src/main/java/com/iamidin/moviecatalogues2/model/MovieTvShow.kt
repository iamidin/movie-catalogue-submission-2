package com.iamidin.moviecatalogues2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieTvShow(
    var photo: Int,
    var name: String,
    var directed: String,
    var genre: String,
    var rating: Float,
    var description: String
) : Parcelable