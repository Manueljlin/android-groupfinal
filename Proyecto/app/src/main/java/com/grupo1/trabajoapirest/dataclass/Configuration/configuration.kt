package com.grupo1.trabajoapirest.dataclass.Configuration


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class configuration(
    @SerializedName("change_keys")
    val changeKeys: List<String>?,
    @SerializedName("images")
    val images: Images?
) : Parcelable