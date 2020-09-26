package com.tes.magnakarga.tesmagnakarsafe.model
import com.google.gson.annotations.SerializedName

data class Tes(
    @SerializedName("dept_id")
    val deptId: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)