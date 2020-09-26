package com.tes.magnakarga.tesmagnakarsafe.model
import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("login_state")
    val loginState: String?,
    @SerializedName("login_time")
    val loginTime: Int?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("username")
    val username: String?
)