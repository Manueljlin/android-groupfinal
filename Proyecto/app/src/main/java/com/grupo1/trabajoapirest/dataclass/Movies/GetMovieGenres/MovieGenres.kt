package com.grupo1.trabajoapirest.dataclass.Movies.GetMovieGenres


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class MovieGenres(
    @SerializedName("genres")
    val genres: List<MovieGenre>?
) : Parcelable