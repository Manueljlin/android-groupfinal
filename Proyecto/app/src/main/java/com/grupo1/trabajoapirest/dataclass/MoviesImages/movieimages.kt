package com.grupo1.trabajoapirest.dataclass.MoviesImages


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class movieimages(
    @SerializedName("backdrops")
    val backdrops: List<Backdrop>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("posters")
    val posters: List<Poster>?
) : Parcelable