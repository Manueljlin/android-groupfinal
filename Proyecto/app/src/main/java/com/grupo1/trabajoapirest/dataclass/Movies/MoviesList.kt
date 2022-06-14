package com.grupo1.trabajoapirest.dataclass.Movies


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class MoviesList(
	@SerializedName("page")
    val page: Int?,
	@SerializedName("results")
    val results: List<Movie>?,
	@SerializedName("total_pages")
    val totalPages: Int?,
	@SerializedName("total_results")
    val totalResults: Int?
) : Parcelable