package com.example.examenfinal.backend
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WSusuarios(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("status") val status: String
)
