package com.tes.magnakarga.tesmagnakarsafe.model

import com.google.gson.annotations.SerializedName

data class ResponseMessage (
    @SerializedName("message")
    val message : String?,
    @SerializedName("error_message")
    val errorMessage : String?
)