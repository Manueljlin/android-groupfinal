package com.grupo1.trabajoapirest.dataclass.Movies.GetApiConfiguration


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ApiConfiguration(
    @SerializedName("images")
    val images: Images,
    @SerializedName("change_keys")
    val changeKeys: List<String>
) : Parcelable