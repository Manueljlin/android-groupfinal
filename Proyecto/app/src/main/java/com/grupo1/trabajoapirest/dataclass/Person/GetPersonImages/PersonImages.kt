package com.grupo1.trabajoapirest.dataclass.Person.GetPersonImages


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class PersonImages(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("profiles")
    val profiles: List<Profile>?
) : Parcelable