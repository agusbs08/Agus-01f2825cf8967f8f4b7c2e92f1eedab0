package com.tes.magnakarga.tesmagnakarsafe.model

import com.google.gson.annotations.SerializedName

data class Register (
    @SerializedName("username")
    val username : String?,
    @SerializedName("password")
    val password : String?,
    @SerializedName("logintime")
    val loginTime : Long?
)