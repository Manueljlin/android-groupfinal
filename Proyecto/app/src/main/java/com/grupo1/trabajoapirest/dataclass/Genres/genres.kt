package com.grupo1.trabajoapirest.dataclass.Genres


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class genres(
    @SerializedName("genres")
    val genres: List<Genre>?
) : Parcelable