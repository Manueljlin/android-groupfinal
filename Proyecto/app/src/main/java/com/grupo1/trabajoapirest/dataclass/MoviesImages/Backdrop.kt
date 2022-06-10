package com.grupo1.trabajoapirest.dataclass.MoviesImages


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import kotlinx.parcelize.RawValue

@Parcelize
data class Backdrop(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double?,
    @SerializedName("file_path")
    val filePath: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("iso_639_1")
    val iso6391: @RawValue Any? = null,
    @SerializedName("vote_average")
    val voteAverage: Int?,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("width")
    val width: Int?
) : Parcelable