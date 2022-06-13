package com.grupo1.trabajoapirest.dataclass.Movies.GetApiConfiguration


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Images(
    @SerializedName("backdrop_sizes")
    val backdropSizes: List<String>?,
    @SerializedName("base_url")
    val baseUrl: String?,
    @SerializedName("logo_sizes")
    val logoSizes: List<String>?,
    @SerializedName("poster_sizes")
    val posterSizes: List<String>?,
    @SerializedName("profile_sizes")
    val profileSizes: List<String>?,
    @SerializedName("secure_base_url")
    val secureBaseUrl: String?,
    @SerializedName("still_sizes")
    val stillSizes: List<String>?
) : Parcelable