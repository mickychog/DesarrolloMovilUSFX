package com.example.examenfinal.backend

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("meta") val meta: Meta?,
    @SerializedName("data") val data: List<WSusuarios>
)





