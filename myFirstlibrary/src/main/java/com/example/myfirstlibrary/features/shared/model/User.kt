package com.example.myfirstlibrary.features.shared.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class User(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("avatar")
    var avatar: String? = null,
    @SerializedName("email")
    var email: String? = null
)