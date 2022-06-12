package com.grupo1.trabajoapirest.dataclass2


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Pelis2(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<ListaPelis2>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
) : Parcelable